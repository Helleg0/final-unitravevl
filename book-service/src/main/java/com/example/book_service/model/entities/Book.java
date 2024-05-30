package com.example.book_service.model.entities;


import jakarta.persistence.*;
import lombok.*;

import java.awt.*;
import java.util.Date;

@Entity
@Table(name = "book_agency")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Book {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Long idBook;
    private Long idAccommodation;
    private Long idDestiny;
    private Long idFly;
    private Long idUser;
    private Long price;
    private Date date;
    private Long guests;

    @Override
    public String toString(){
        return "Book{"+"id " + idBook+ "idAccommodation"+idAccommodation+"idDestiny"+idDestiny+
                "idFly"+idFly+"idUser"+idUser+"price"+price+"date"+date+"guests"+guests+"}";
    }
}
