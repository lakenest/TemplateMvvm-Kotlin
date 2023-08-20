package com.example.appbasemvvm.data

import com.example.appbasemvvm.data.model.QuoteModel
import com.example.appbasemvvm.data.model.QuoteProvider
import com.example.appbasemvvm.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuote():List<QuoteModel>{
        val response:List<QuoteModel> = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}