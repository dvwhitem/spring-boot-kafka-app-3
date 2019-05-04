package com.dv.springbootkafkaapp3;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Getter
public class Consumer {

    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    private final List<SampleMessage> messages = new CopyOnWriteArrayList<>();

    @KafkaListener(topics = "${app.topic.name}")
    public void processMessage(SampleMessage message) {
        this.messages.add(message);
        log.info("Received sample message= '{}' ", message);
    }
}
