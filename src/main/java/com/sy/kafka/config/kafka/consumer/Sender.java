package com.sy.kafka.config.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * 消息发送类
 */
@Slf4j
public class Sender {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void send(String topic,String payload) {
        log.info("sending payload='{}' to topic='{}'",payload,topic);
        this.kafkaTemplate.send(topic,payload);
    }

}
