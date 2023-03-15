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

package org.laokou.test.datasource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.laokou.test.datasource.entity.TestEntity;
import org.laokou.test.datasource.mapper.TestMapper;
import org.laokou.test.datasource.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author laokou
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, TestEntity> implements TestService {
}
