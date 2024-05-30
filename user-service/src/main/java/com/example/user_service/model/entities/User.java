package com.example.user_service.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_agency")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int id_rol;
    private String name;
    private String document;
    private String address;
    private String phone;

    @Override
    public String toString(){
        return "User{"+
                "id "+ id +
                "id_rol: "+ id_rol +
                ", name: " + name+
                ", c.c: " + document +
                ", address: " + address +
                ", phone: " + phone + "}";
    }

}
