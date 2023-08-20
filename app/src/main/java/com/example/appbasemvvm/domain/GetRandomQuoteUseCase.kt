package com.example.appbasemvvm.domain

import com.example.appbasemvvm.data.model.QuoteModel
import com.example.appbasemvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {

    operator fun invoke():QuoteModel?{
        val quotes = QuoteProvider.quotes
        if (quotes.isNotEmpty()){
            val randomNumber = (quotes.indices-1).random()
            return quotes[randomNumber]
        }
        return null
    }
}