package com.example.appbasemvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appbasemvvm.data.model.QuoteModel
import com.example.appbasemvvm.domain.GetQuotesUseCase
import com.example.appbasemvvm.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    /***mutable live data del modelo de datos***/
    val quoteModel = MutableLiveData<QuoteModel?>()
    /***llamando a un progress bar***/
    val isLoading = MutableLiveData<Boolean>()

    /***ceramos instancias de los casos de uso***/
    val getQuotesUseCase = GetQuotesUseCase()
    val getRandomQuoteUseCase = GetRandomQuoteUseCase()



    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()
            if(result.isNotEmpty()){
                quoteModel.postValue(result[1])
                isLoading.postValue(false)
            }
        }

    }

    fun randomQuote(){
        isLoading.postValue(true)
        /***accedemos al provider***/
        //val currentQuote = QuoteProvider.random()
        //quoteModel.postValue(currentQuote)
        val quote = getRandomQuoteUseCase()
        if (quote!=null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }

}