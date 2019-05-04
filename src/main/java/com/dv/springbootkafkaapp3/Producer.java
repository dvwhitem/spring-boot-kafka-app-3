package com.dv.springbootkafkaapp3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private static final Logger log = LoggerFactory.getLogger(Producer.class);

    @Value("${app.topic.name}")
    private String topicName;

    private final KafkaTemplate<Object, SampleMessage> kafkaTemplate;

    public Producer(KafkaTemplate<Object, SampleMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(SampleMessage message) {
        this.kafkaTemplate.send(this.topicName, message);
        log.info("Sent sample message= '{}'", message);
    }
}
