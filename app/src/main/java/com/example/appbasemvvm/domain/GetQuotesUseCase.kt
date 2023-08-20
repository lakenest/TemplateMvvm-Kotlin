package com.example.appbasemvvm.domain

import com.example.appbasemvvm.data.QuoteRepository
import com.example.appbasemvvm.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    /***@Inject Prepara clases que no son act ni viewmodel para ser inyectadas**/
    private val repository:QuoteRepository
) {
    /**Dagger hilt evita que haya instancias de clase, es mejo ubicarlas en el @Inject**/
    //private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>{
        return repository.getAllQuote()
    }

}