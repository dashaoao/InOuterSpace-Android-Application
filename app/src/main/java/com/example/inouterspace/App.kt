package com.example.inouterspace

import android.app.Application
import com.example.inouterspace.di.appModule
import com.example.inouterspace.di.dataModule
import com.example.inouterspace.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(appModule, dataModule, networkModule)
        }
    }
}
