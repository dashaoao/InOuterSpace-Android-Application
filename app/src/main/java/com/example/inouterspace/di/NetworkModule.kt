package com.example.inouterspace.di


import com.example.inouterspace.data.api.CrewApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.spacexdata.com/v4/"

val networkModule = module {

    single{
        val retrofit: Retrofit = get()
        retrofit.create(CrewApi::class.java)
    }

    single <Retrofit> {
        val okHttpClient: OkHttpClient = get()
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    single {
        val httpLoggingInterceptor : HttpLoggingInterceptor = get()
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    single {
        HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
    }
}