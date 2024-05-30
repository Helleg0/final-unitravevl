package com.example.book_service.config;


import com.example.book_service.model.entities.Book;
import com.example.book_service.services.BookInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class Messages {
    private final BookInterface bookInterface;

    @RabbitListener(queues = constants.QUEUE )
    public Object receiveMessageAndReply() {
        List<Book> buscado = bookInterface.getAllBooks();
        System.out.println("ALL Books: (books-service) " + buscado);
        return buscado;
    }
}
