package com.example.appbasemvvm.domain

import com.example.appbasemvvm.data.model.QuoteModel
import com.example.appbasemvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    /***@Inject Prepara clases que no son act ni viewmodel para ser inyectadas*/
    private val quoteProvider: QuoteProvider
){

    operator fun invoke():QuoteModel?{
        val quotes = quoteProvider.quotes
        if (quotes.isNotEmpty()){
            val randomNumber = (quotes.indices-1).random()
            return quotes[randomNumber]
        }
        return null
    }
}