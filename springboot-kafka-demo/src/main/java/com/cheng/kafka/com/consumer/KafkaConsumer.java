package com.cheng.kafka.com.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {


    @KafkaListener(topics = "test",groupId = "defaultConsumerGroup")
    public void listenDefaultGroup(ConsumerRecord<String, String> record, Acknowledgment ack) {
        String value = record.value();
        System.out.println("接受消息如下：======================================start========================");
        System.out.println(value);
        System.out.println(record);
        System.out.println("================================end==============================");
        //手动提交offset
        ack.acknowledge();
    }
}
