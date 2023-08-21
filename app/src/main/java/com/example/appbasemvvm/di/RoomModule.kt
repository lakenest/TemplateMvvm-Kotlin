package com.example.appbasemvvm.di

import android.content.Context
import androidx.room.Room
import com.example.appbasemvvm.data.database.QuoteDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val QUOTE_DB_NAME = "quote_database"
    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, QuoteDataBase::class.java, QUOTE_DB_NAME).build()

    @Singleton
    @Provides
    fun provideIQuoteDao(dataBase: QuoteDataBase) = dataBase.getQuoteDao()
}