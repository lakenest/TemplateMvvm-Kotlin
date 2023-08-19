package com.example.appbasemvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appbasemvvm.model.QuoteModel
import com.example.appbasemvvm.model.QuoteProvider

class QuoteViewModel : ViewModel() {

    /***mutable live data del modelo de datos***/
    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote(){
        /***accedemos al provider***/
        val currentQuote = QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }

}