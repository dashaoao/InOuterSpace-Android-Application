package com.example.inouterspace.di

import com.example.inouterspace.data.CrewRepositoryImpl
import com.example.inouterspace.presentation.CrewViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

//    single {
//        AppDatabase.getInstance(application = androidApplication())
//    }
//
//    single {
//        val db: AppDatabase = get()
//        db.shopListDao()
//    }

    viewModel {
        CrewViewModel(crewRepository = get())
    }

}