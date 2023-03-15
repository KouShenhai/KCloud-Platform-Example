/**
 * Copyright (c) 2022 KCloud-Platform-Alibaba Authors. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.laokou.test.datasource.controller;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.laokou.test.datasource.utils.TransactionalUtil;
import org.laokou.test.datasource.entity.TestEntity;
import org.laokou.test.datasource.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author laokou
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final TransactionalUtil transactionalUtil;
    private final TestService testService;

    private static final ThreadPoolExecutor TASK_THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(
            9,
            9,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(256),
            new ThreadPoolExecutor.CallerRunsPolicy());

    private static final AtomicBoolean STOP = new AtomicBoolean(false);

    @SneakyThrows
    @GetMapping("/start")
    public void start(){
        STOP.set(false);
        // 10w数据
        long size = 100000;
        // 一次插入5000条
        int chunkSize = 5000;
        // 批次
        int count = (int) (size / chunkSize + (size % chunkSize > 0 ? 1 : 0));
        // 计数器
        CountDownLatch countDownLatch = new CountDownLatch(count);
        List<TestEntity> longList = new ArrayList<>((int) size);
        for (long i = 1; i <= size; i++) {
            longList.add(new TestEntity(i));
        }
        AtomicBoolean rollback = new AtomicBoolean(false);
        List<List<TestEntity>> partition = Lists.partition(longList, chunkSize);
        for (int i = 0; i < count; i++) {
            log.info("批量次数：{}，当前线程：{}",i,Thread.currentThread().getName());
            int finalI = i;
            TASK_THREAD_POOL_EXECUTOR.execute(() -> transactionalUtil.execute(callback -> {
                try {
                    // 执行插入操作
                    testService.saveBatch(partition.get(finalI));
                    log.info("正在插入数据，请稍后。。。");
                } catch (Exception e) {
                    // 回滚标识
                    rollback.set(true);
                    log.error("插入失败，已标识回滚。。。");
                } finally {
                    // 判断是否需要停止导入
                    if (STOP.get()) {
                        // 事务回滚标志
                        callback.setRollbackOnly();
                        log.info("导入已暂停。。。");
                    }
                    if (rollback.get()) {
                        // 事务回滚标志
                        callback.setRollbackOnly();
                    }
                    countDownLatch.countDown();
                    return true;
                }
            }));
        }
        // 30秒后结束阻塞
        log.info("主线程阻塞中。。。");
        countDownLatch.await(30, TimeUnit.SECONDS);
        log.info("导入成功。。。");
    }

    @GetMapping("/stop")
    public void stop(){
        STOP.set(true);
    }

}
