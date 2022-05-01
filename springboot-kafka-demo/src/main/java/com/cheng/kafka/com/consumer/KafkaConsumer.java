package com.cheng.kafka.com.consumer;

import com.alibaba.fastjson2.JSONObject;
import com.cheng.kafka.com.entity.MessageDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @KafkaListener(topics = "topic1", groupId = "defaultConsumerGroup1")
    public void listenDefaultGroup1(ConsumerRecord<String, String> record, Acknowledgment ack) {
        final MessageDTO value = JSONObject.parseObject(record.value(), MessageDTO.class);
        System.out.println("接消费阶段1消息如下：======================================start========================");
        System.out.println(value);
        System.out.println(record);
        System.out.println("================================end==============================");
        //手动提交offset
        ack.acknowledge();

        kafkaTemplate.send("topic2", String.valueOf((value.getHandleId() + 1)));
    }

    @KafkaListener(topics = "topic2", groupId = "defaultConsumerGroup2")
    public void listenDefaultGroup2(ConsumerRecord<String, String> record, Acknowledgment ack) {
        String value = record.value();
        System.out.println("消费阶段2：======================================start========================");
        System.out.println(value);
        System.out.println(record);
        System.out.println("================================end==============================");
        //手动提交offset
        ack.acknowledge();
    }
}
