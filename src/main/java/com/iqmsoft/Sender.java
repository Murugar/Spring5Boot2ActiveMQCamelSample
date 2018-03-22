package com.iqmsoft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {

    private static Logger log = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(Order myMessage) {
        log.info("sending with convertAndSend() to queue <" + myMessage + ">");
        jmsTemplate.convertAndSend(Config.ORDER_QUEUE, myMessage);
    }
}
