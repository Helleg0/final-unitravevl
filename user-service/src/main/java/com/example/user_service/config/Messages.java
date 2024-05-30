package com.example.user_service.config;


import com.example.user_service.model.entities.User;
import com.example.user_service.services.UserInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class Messages {
    private final UserInterface userInterface;

    @RabbitListener(queues = constants.QUEUE )
    public Object receiveMessageAndReply() {
        List<User> buscado = userInterface.getAllUsers();
        System.out.println("ALL Users: (user-service) " + buscado);
        return buscado;
    }
}
