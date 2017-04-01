package com.lv.messageq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * 消息生产者.
 */
@Component
@EnableScheduling
public class Producer {
   
    @Autowired
    private JmsMessagingTemplate mMessagingTemplate;
   
    @Autowired
    private Queue queue;
   
    @Scheduled(fixedDelay=300000)//每3s执行1次
    public void sendMessage() {
       this.mMessagingTemplate.convertAndSend(this.queue, "hi,activeMQ");
    }
   
}