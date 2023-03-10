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

package org.laokou.test.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author laokou
 */
@Slf4j
@SpringBootTest(classes = RocketmqApplication.class)
public class MQTest {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void test() {
        rocketMQTemplate.sendOneWay("test","333");
    }

    @Test
    public void test2() throws MQClientException {
//        DefaultLitePullConsumer defaultLitePullConsumer = new DefaultLitePullConsumer();
//        defaultLitePullConsumer.setNamesrvAddr("192.168.62.144:9876");
//        defaultLitePullConsumer.setConsumerGroup("laokou-consumer-group");
//        List<String> receive = rocketMQTemplate.receive(String.class);
//        System.out.println(receive.size());
//        List<String> receive = rocketMQTemplate.receive(String.class);
//        System.out.println(receive.size());
        DefaultMQPushConsumer defaultMQPushConsumer = new DefaultMQPushConsumer();
        defaultMQPushConsumer.setNamesrvAddr("192.168.62.144:9876");
        defaultMQPushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        defaultMQPushConsumer.setConsumerGroup("laokou-consumer-group");
        defaultMQPushConsumer.subscribe("test","*");
        defaultMQPushConsumer.registerMessageListener(new MessageListenerOrderly() { // 注册消息监听(顺序方式)
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
                for (MessageExt msg : msgs) {
                    System.out.println(new String(msg.getBody()));
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        defaultMQPushConsumer.start();
    }

}
