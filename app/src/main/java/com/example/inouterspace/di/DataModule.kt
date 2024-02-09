package com.example.inouterspace.di

import com.example.inouterspace.data.CrewRepositoryImpl
import com.example.inouterspace.domain.repository.CrewRepository
import org.koin.dsl.module

val dataModule = module {

    single <CrewRepository> {
        CrewRepositoryImpl(crewApi = get())
    }
}