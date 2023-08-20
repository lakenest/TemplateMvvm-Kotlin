package com.example.appbasemvvm.data.network

import com.example.appbasemvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface IQuoteApiClient {
    @GET(".json")
    suspend fun getAllQuotes():Response<List<QuoteModel>>
}