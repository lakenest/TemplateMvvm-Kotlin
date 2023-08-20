package com.example.appbasemvvm.data

import com.example.appbasemvvm.data.model.QuoteModel
import com.example.appbasemvvm.data.model.QuoteProvider
import com.example.appbasemvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    /**95% de las clases basta con @Inject para trabjar con dagger hilt**/
    private  val api:QuoteService,
    private val quoteProvider: QuoteProvider
) {

    //private val api = QuoteService()

    suspend fun getAllQuote():List<QuoteModel>{
        val response:List<QuoteModel> = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}