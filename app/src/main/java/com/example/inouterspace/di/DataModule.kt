package com.example.inouterspace.di

import com.example.inouterspace.data.CrewRepositoryImpl
import org.koin.dsl.module

val dataModule = module {

    single {
        CrewRepositoryImpl(crewApi = get())
    }
}