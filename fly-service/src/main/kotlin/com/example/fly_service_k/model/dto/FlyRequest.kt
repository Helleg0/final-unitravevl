package com.example.fly_service_k.model.dto

data class FlyRequest(
    var id: Long? = null,
    var id_plane: Int = 0,
    var date_fly: String? = null,
    var departure_city: String? = null,
    var arrive_city: String? = null,
    var flyTime: Long? = null
)