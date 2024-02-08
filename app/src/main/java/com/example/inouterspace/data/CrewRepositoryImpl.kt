package com.example.inouterspace.data

import com.example.inouterspace.data.api.CrewApi
import com.example.inouterspace.data.api.model.toDomain
import com.example.inouterspace.domain.model.CrewMember
import com.example.inouterspace.domain.repository.CrewRepository

class CrewRepositoryImpl(
    private val crewApi: CrewApi,
) : CrewRepository {
    override suspend fun getCrew(): List<CrewMember> = crewApi.getCrew().mapNotNull { it.toDomain() }
}