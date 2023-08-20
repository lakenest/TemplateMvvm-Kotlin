package com.example.appbasemvvm.domain

import com.example.appbasemvvm.data.QuoteRepository
import com.example.appbasemvvm.data.model.QuoteModel

class GetQuotesUseCase {
    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>{
        return repository.getAllQuote()
    }

}