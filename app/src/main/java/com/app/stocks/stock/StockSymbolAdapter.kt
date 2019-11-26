package com.app.stocks.stock

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.stocks.R
import kotlinx.android.synthetic.main.stock_symbol.view.*

class StockSymbolAdapter : RecyclerView.Adapter<StockItemViewHolder>() {
    var items: List<Stock> = emptyList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = StockItemViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.stock_symbol, parent, false)
    )
    override fun getItemCount() = items.size
    override fun onBindViewHolder(holder: StockItemViewHolder, position: Int) = holder.bindTo(items[position])
}

class StockItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindTo(stock: Stock) {
        itemView.apply {
            symbol.text = stock.symbol
            name.text = stock.name
            price.text = stock.price.toString()
        }
    }
}