package com.cheng.kafka.com.controller;

import com.alibaba.fastjson2.JSON;
import com.cheng.kafka.com.entity.MessageDTO;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class KafkaController {

    private final static String TOPIC_NAME = "topic1";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/send")
    public void send(@RequestParam String data) {
        Date now = new Date();
        System.out.println("发送时间：=================  " + now);


        kafkaTemplate.send(TOPIC_NAME,
                JSON.toJSONString(new MessageDTO().setTopicName(TOPIC_NAME).setMessage(data).setHandleId(0)));
    }
}
