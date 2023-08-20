package com.example.appbasemvvm.di

import com.example.appbasemvvm.data.network.IQuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/***Clase que nos devuelve dependencias que no son faciles de injectar por ejem retrofit apra el otro 5%**/
@Module
@InstallIn(SingletonComponent::class)//Alcance ejem activiy la instancia muere con el activity
object NetworkModule {
    //proveer retrofit
    @Singleton //usar patron de diseño singleton, una sola isntancia de retrofit
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton //usar patron de diseño singleton, una sola isntancia de retrofit
    @Provides
    fun provideIQuoteApiClient(retrofit: Retrofit):IQuoteApiClient{
        return retrofit.create(IQuoteApiClient::class.java)
    }
}