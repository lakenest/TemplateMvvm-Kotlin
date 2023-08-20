package com.example.appbasemvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.appbasemvvm.databinding.ActivityMainBinding
import com.example.appbasemvvm.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint /***Anotacion Clase preparada para inyectarse dependencias*/
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    /**accedemos al viewmodel**/
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        /***llamar al viewmodel example***/
        quoteViewModel.quoteModel.observe(this) { currentQuote ->
            if (currentQuote != null) {
                binding.tvQuote.text = currentQuote.quote
                binding.tvAuthor.text = currentQuote.author
            }


        }
        /***llamar al viewmodel example***/
        quoteViewModel.isLoading.observe(this) {
            binding.pbChargeQuote.isVisible = it
        }

        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }


    }
}