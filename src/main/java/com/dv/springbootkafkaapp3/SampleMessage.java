package com.dv.springbootkafkaapp3;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@Getter
@ToString
public class SampleMessage {

    private final Integer id;

    private final String message;

    @JsonCreator
    public SampleMessage(@JsonProperty("id")  Integer id, @JsonProperty("message") String message) {
        this.id = id;
        this.message = message;
    }
}
