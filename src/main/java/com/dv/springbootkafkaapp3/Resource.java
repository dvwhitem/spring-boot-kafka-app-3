package com.dv.springbootkafkaapp3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class Resource {

    @Autowired
    private Producer producer;

    @PostMapping("/message")
    public void message(@RequestBody SampleMessage sampleMessage) {
        producer.send(sampleMessage);
    }
}
