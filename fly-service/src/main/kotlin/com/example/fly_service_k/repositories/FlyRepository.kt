package com.example.fly_service_k.repositories

import com.example.fly_service_k.model.entities.Fly
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface FlyRepository : JpaRepository<Fly, Long> {
    @Query("SELECT f FROM Fly f")
    fun findAllFlights(): List<Fly>
}