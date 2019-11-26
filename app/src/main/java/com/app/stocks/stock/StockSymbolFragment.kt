package com.app.stocks.stock

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.app.stocks.R
import kotlinx.android.synthetic.main.fragment_stock_list.view.*

class StockSymbolFragment : Fragment() {

    private val stockSymbolAdapter = StockSymbolAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_stock_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.recyclerView.apply {
            adapter = stockSymbolAdapter
            addItemDecoration(DividerItemDecoration(this@StockSymbolFragment.context, DividerItemDecoration.VERTICAL))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProviders.of(this)[StocksViewModel::class.java]
        viewModel.stocks.observe(this, Observer<List<Stock>> { stocks ->
            stockSymbolAdapter.items = stocks
        })

    }
}