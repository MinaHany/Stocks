package com.app.stocks.stock

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class StocksViewModel : ViewModel(), CoroutineScope {
    override val coroutineContext = Dispatchers.IO
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://financialmodelingprep.com/api/v3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val stocks: MutableLiveData<List<Stock>> by lazy {
        MutableLiveData<List<Stock>>().also {
            launch { loadStocks() }
        }
    }

    private suspend fun loadStocks() {
        stocks.postValue(retrofit.create(StocksService::class.java).getAll().symbolsList)
    }
}