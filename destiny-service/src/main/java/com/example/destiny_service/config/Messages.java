package com.example.destiny_service.config;



import com.example.destiny_service.model.entities.Destiny;
import com.example.destiny_service.services.DestinyInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class Messages {
    private final DestinyInterface destinyInterface;

    @RabbitListener(queues = constants.QUEUE )
    public Object receiveMessageAndReply() {
        List<Destiny> buscado = destinyInterface.getAllBooks();
        System.out.println("ALL Destiny: (destiny-service) " + buscado);
        return buscado;
    }
}
