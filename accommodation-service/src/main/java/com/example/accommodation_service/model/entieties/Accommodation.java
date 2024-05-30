package com.example.accommodation_service.model.entieties;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@Entity
@Table(name = "accommodation_agency")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String characteristics;
    private Integer maxCapacity;
    private Integer price;
    private boolean status;

    @Override
    public String toString(){
        return "Accommodation{"+
                "id"+id+
                "name"+name+
                "location"+location+
                "characteristics"+characteristics+
                "maxCapacity"+maxCapacity+
                "price"+price+
                "status"+status+"}";
    }

}
