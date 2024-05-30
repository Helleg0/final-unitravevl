package com.example.destiny_service.config;



import com.example.destiny_service.model.entities.Destiny;
import com.example.destiny_service.services.destinyInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class Messages {
    private final flyInterface flyInterface;

    @RabbitListener(queues = constants.QUEUE )
    public Object receiveMessageAndReply() {
        List<Fly> buscado = flyInterface.getAllflys();
        System.out.println("ALL Fly: (fly-service) " + buscado);
        return buscado;
    }
}
