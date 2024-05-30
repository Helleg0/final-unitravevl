package com.example.fly_service_k.controllers

import com.example.fly_service_k.model.dto.FlyRequest
import com.example.fly_service_k.model.dto.FlyResponse
import com.example.fly_service_k.model.entities.Fly
import com.example.fly_service_k.service.FlyService
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/fly")
@RequiredArgsConstructor
class FlyController(private val flyService: FlyService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addFly(@RequestBody flyRequest: FlyRequest) {
        flyService.addFly(flyRequest)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllFlys(): List<Fly> {
        return flyService.getAllFlys()
    }

    @PutMapping("/{flyId}")
    fun updateFly(@PathVariable flyId: Long, @RequestBody flyRequest: FlyRequest) {
        flyRequest.id = flyId
        flyService.updateUser(flyRequest)
    }

    @DeleteMapping("/{flyId}")
    fun deleteFly(@PathVariable flyId: Long) {
        flyService.deleteFly(flyId)
    }
}