package com.app.stocks.stock

import retrofit2.http.GET

interface StocksService {

    @GET("company/stock/list")
    suspend fun getAll(): StockListResponse
}

data class StockListResponse(val symbolsList: List<Stock>)

data class Stock(val symbol: String, val name: String, val price: Float)