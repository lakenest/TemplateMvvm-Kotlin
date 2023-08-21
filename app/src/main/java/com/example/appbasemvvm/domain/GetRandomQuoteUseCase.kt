package com.example.appbasemvvm.domain

import com.example.appbasemvvm.data.QuoteRepository
import com.example.appbasemvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    /***@Inject Prepara clases que no son act ni viewmodel para ser inyectadas*/
    //private val quoteProvider: QuoteProvider - se elimina, el proveedor ahora sera room
    private val repository: QuoteRepository
){

    suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuotesFromDatabase()
        if (quotes.isNotEmpty()){
            val randomNumber = (quotes.indices-1).random()
            return quotes[randomNumber]
        }
        return null
    }
}