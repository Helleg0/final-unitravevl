package com.example.book_service.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequest {
    private  Long idBook;
    private Long idAccommodation;
    private Long idDestiny;
    private Long idFly;
    private Long idUser;
    private Long price;
    private Date date;
    private Long guests;
}
