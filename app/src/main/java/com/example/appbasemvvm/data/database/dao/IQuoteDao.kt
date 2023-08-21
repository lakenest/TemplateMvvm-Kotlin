package com.example.appbasemvvm.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appbasemvvm.data.database.entity.QuoteEntity

@Dao
interface IQuoteDao {

    @Query("SELECT * FROM tquote ORDER BY  author DESC")
    suspend fun getAllQuotes():List<QuoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes:List<QuoteEntity>)

    @Query("DELETE FROM tquote")
    suspend fun deleteAllQuotes()
}