package com.kaisa.mvvmhilt.di

import com.kaisa.mvvmhilt.data.remote.DummyAPI
import com.kaisa.mvvmhilt.util.Constantes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//Modulo hilt
@Module
@InstallIn(ViewModelComponent::class)
object Appmodulo {
    @Provides
    fun proverRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constantes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    @Provides
    fun proverDummyAPI(retrofit: Retrofit): DummyAPI {
        return retrofit.create(DummyAPI::class.java)

    }
}