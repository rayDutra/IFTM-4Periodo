package com.logs.startexample.mensages;

import com.logs.startexample.models.dtos.LogDTO;
import com.logs.startexample.services.LogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqReadLog {

    @Autowired
    private LogService logService;

    @RabbitListener(queues = "${newsletter.rabbitmq.queue}")
    public void receiveLog(@Payload LogDTO logDTO) {
        if(logDTO != null)
            logService.save(logDTO);
    }
}