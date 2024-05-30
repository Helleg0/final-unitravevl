package com.example.fly_service_k.service

import com.example.fly_service_k.model.dto.FlyRequest
import com.example.fly_service_k.model.dto.FlyResponse
import com.example.fly_service_k.model.entities.Fly
import com.example.fly_service_k.repositories.FlyRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class FlyService(private val flyRepository: FlyRepository) {

    private val log = LoggerFactory.getLogger(FlyService::class.java)

    fun addFly(flyRequest: FlyRequest) {
        val fly = Fly(
            id = flyRequest.id,
            id_plane = flyRequest.id_plane,
            date_fly = flyRequest.date_fly,
            departure_city = flyRequest.departure_city,
            arrive_city = flyRequest.arrive_city,
            flyTime = flyRequest.flyTime
        )
        flyRepository.save(fly)
        log.info("fly added: {}", fly)
    }

    fun getAllFlys(): List<Fly> {
        return flyRepository.findAllFlights()
    }

    fun updateFly(flyRequest: FlyRequest) {
        val optionalFly = flyRequest.id?.let { flyRepository.findById(it) }

        if (optionalFly != null) {
            if (optionalFly.isPresent) {
                val fly = optionalFly.get()

                fly.id_plane = flyRequest.id_plane
                fly.date_fly = flyRequest.date_fly
                fly.departure_city = flyRequest.departure_city
                fly.arrive_city = flyRequest.arrive_city

                flyRepository.save(fly)

                log.info("fly updated: {}", fly)
            } else {
                log.error("fly with ID {} not found", flyRequest.id)
            }
        }
    }

    fun deleteFly(flyId: Long) {
        val optionalFly = flyRepository.findById(flyId)

        if (optionalFly.isPresent) {
            flyRepository.deleteById(flyId)
        } else {
            throw NoSuchElementException("Fly with ID $flyId not found")
        }
    }
}