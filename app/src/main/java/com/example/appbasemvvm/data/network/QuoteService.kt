package com.example.appbasemvvm.data.network

import com.example.appbasemvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject


class QuoteService @Inject constructor(
    /**95% de las clases basta con @Inject para trabjar con dagger hilt**/
    private val api:IQuoteApiClient
){

    //private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes():List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response: Response<List<QuoteModel>> = api.getAllQuotes()
            response.body()?: emptyList()
        }
    }
}