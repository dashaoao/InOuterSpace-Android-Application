package com.example.inouterspace.domain.repository

import com.example.inouterspace.domain.model.CrewMember

interface CrewRepository {
    suspend fun getCrew(): List<CrewMember>
}