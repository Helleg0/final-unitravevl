package com.example.fly_service_k.model.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.util.Date


@Entity
@Table(name = "fly_agency")
data class Fly(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var id_plane: Int = 0,
    var date_fly: String? = null,
    var departure_city: String? = null,
    var arrive_city: String? = null,
    var flyTime: Long? = null
) {



    override fun toString(): String {
        return "Fly(id=$id, id_plane=$id_plane, date_fly=$date_fly, departure_city=$departure_city, arrive_city=$arrive_city, flyTime=$flyTime)"
    }
}