package com.example.fly_service_k.model.dto

class FlyResponse {
    data class FlyResponse(
        var id: Long?,
        var id_plane: Int ,
        var date_fly: String? ,
        var departure_city: String? ,
        var arrive_city: String? ,
        var flyTime: Long?
    )
}