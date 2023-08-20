package com.example.appbasemvvm.data.network

import com.example.appbasemvvm.core.RetrofitHelper
import com.example.appbasemvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


class QuoteService{

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes():List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response: Response<List<QuoteModel>> = retrofit.create(IQuoteApiClient::class.java).getAllQuotes()
            response.body()?: emptyList()
        }
    }
}