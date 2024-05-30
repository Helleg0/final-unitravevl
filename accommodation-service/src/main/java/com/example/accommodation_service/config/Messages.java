package com.example.accommodation_service.config;

import com.example.accommodation_service.model.entieties.Accommodation;
import com.example.accommodation_service.services.AccommodationInterface;
import com.example.accommodation_service.services.AccommodationService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class Messages {
    private final AccommodationInterface accommodationInterface;

    @RabbitListener(queues = constants.QUEUE )
    public Object receiveMessageAndReply() {
        List<Accommodation> buscado = accommodationInterface.getAllAccommodations();
        System.out.println("ALL ACCOMMODATIONS: (Alojamiento-service) " + buscado);
        return buscado;
    }
}
