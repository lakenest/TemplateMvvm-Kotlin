package com.example.appbasemvvm.ui.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appbasemvvm.domain.GetQuotesUseCase
import com.example.appbasemvvm.domain.GetRandomQuoteUseCase
import com.example.appbasemvvm.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel /***Anotacion ViewModel preparado para inyectarse dependencias*/
class QuoteViewModel @Inject constructor(
    /***Dentro de Inject contructor se inyecta lo que quieres*/
    private val getQuotesUseCase:GetQuotesUseCase,
    private val getRandomQuoteUseCase:GetRandomQuoteUseCase
) : ViewModel() {

    /***mutable live data del modelo de datos***/
    val quoteModel = MutableLiveData<Quote>()
    /***llamando a un progress bar***/
    val isLoading = MutableLiveData<Boolean>()

    /***ceramos instancias de los casos de uso***/
    //val getQuotesUseCase = GetQuotesUseCase()
    //val getRandomQuoteUseCase = GetRandomQuoteUseCase()


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

    @SuppressLint("NullSafeMutableLiveData")
    fun randomQuote(){
        isLoading.postValue(true)
        /***accedemos al provider***/
        //val currentQuote = QuoteProvider.random()
        //quoteModel.postValue(currentQuote)
        viewModelScope.launch {
            val quote = getRandomQuoteUseCase()
            if (quote!=null){
                quoteModel.postValue(quote)
            }
            isLoading.postValue(false)
        }

    }

}