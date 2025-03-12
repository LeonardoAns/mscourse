package com.curso.ms.mscreditassessor.infrastructure.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {

    @Value("${mq.queues.card_issuance}")
    private String queueName;

    @Bean
    public Queue cardIssuanceQueue() {
        return new Queue(queueName, true);
    }
}
