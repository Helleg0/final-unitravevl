package com.example.destiny_service.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "destiny_agency")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Destiny {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private String date;
    private Integer maxCapacity;

    private String departure;

    private String arrival;



    @Override
    public String toString(){
        return "Destiny{"+
                "id "+ id +
                ", name: " + name+
                ", description: " + description +
                ", price: " + price +
                ", date: " + date +
                ", maxCapacity: " + maxCapacity +
                ", departure: " + departure +
                ", arrival: " + arrival +"}";
    }

}
