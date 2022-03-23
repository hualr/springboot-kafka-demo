package com.cheng.kafka.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/rest")
public class KafkaController {

    private final static String TOPIC_NAME = "test";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @RequestMapping("/send")
    public void send(){
        Date now = new Date();
        System.out.println("发送时间：=================  "+now.toString());
        kafkaTemplate.send(TOPIC_NAME,"msg:"+now.toString());
    }
}
