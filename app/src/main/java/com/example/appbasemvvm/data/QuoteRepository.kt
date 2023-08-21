package com.example.appbasemvvm.data

import com.example.appbasemvvm.data.database.dao.IQuoteDao
import com.example.appbasemvvm.data.database.entity.QuoteEntity
import com.example.appbasemvvm.data.model.QuoteModel
import com.example.appbasemvvm.data.network.QuoteService
import com.example.appbasemvvm.domain.model.Quote
import com.example.appbasemvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    /**95% de las clases basta con @Inject para trabjar con dagger hilt**/
    private  val api:QuoteService,
    private val iQuoteDao: IQuoteDao
    //private val quoteProvider: QuoteProvider - era un cache local
) {

    //private val api = QuoteService()

    suspend fun getAllQuoteFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        //quoteProvider.quotes = response
        return response.map {it.toDomain()}
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote>{
        val response = iQuoteDao.getAllQuotes()
        return response.map {it.toDomain()}
    }

    suspend fun insertQuote(quotes:List<QuoteEntity>) {
        iQuoteDao.insertAll(quotes)
    }

    suspend fun clearQuote() {
        iQuoteDao.deleteAllQuotes()
    }

}