package org.laokou.test.rocketmq.config;
import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author laokou
 */
@Configuration
public class RocketConfig {

    @Value("${rocketmq.producer.group}")
    private String producerGroup;

    @Value("${rocketmq.name-server}")
    private String nameServer;

    @Bean(name = "rocketTemplate")
    public RocketMQTemplate rocketTemplate() throws MQClientException {
        RocketMQTemplate template = new RocketMQTemplate();
        DefaultMQProducer defaultProducer = new DefaultMQProducer();
        defaultProducer.setProducerGroup(producerGroup);
        defaultProducer.setNamesrvAddr(nameServer);
//        DefaultLitePullConsumer defaultMQPushConsumer = new DefaultLitePullConsumer();
//        defaultMQPushConsumer.setNamesrvAddr(nameServer);
//        defaultMQPushConsumer.setConsumerGroup("laokou-consumer-group");
//        defaultMQPushConsumer.setCustomizedTraceTopic("test");
        template.setProducer(defaultProducer);
//        defaultMQPushConsumer.start();
//        template.setConsumer(defaultMQPushConsumer);
        return template;
    }



}
