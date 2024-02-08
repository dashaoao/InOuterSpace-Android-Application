package com.example.inouterspace.di


import com.example.inouterspace.data.api.CrewApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.spacexdata.com/v4/"

val networkModule = module {

    single {
        provideCrewApiRetrofit(retrofit = get())
    }

    single<Retrofit> {
        provideRetrofit(okHttpClient = get())
    }

    single {
        provideHttpClient(httpLoggingInterceptor = get())
    }

    single {
        HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
    }
}

private fun provideCrewApiRetrofit(retrofit: Retrofit) = retrofit.create(CrewApi::class.java)

private fun provideRetrofit(okHttpClient: OkHttpClient) = Retrofit
    .Builder()
    .baseUrl(BASE_URL)
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

private fun provideHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor) = OkHttpClient
    .Builder()
    .addInterceptor(httpLoggingInterceptor)
    .build()