package com.example.appbasemvvm.domain.model

import com.example.appbasemvvm.data.database.entity.QuoteEntity
import com.example.appbasemvvm.data.model.QuoteModel

data class Quote (
    val quote:String,
    val author:String)

//funciones de extension
fun  QuoteModel.toDomain() = Quote(quote, author)
fun  QuoteEntity.toDomain() = Quote(quote, author)