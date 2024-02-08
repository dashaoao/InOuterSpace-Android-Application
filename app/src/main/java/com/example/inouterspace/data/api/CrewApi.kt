package com.example.inouterspace.data.api

import com.example.inouterspace.data.api.model.CrewMemberDto
import retrofit2.http.GET

interface CrewApi {
    @GET("crew")
    suspend fun getCrew(): List<CrewMemberDto>
}