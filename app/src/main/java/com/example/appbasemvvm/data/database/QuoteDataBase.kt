package com.example.appbasemvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.appbasemvvm.data.database.dao.IQuoteDao
import com.example.appbasemvvm.data.database.entity.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDataBase: RoomDatabase() {

    abstract fun getQuoteDao():IQuoteDao
}