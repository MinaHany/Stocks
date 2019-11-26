package com.app.stocks

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.app.stocks.stock.FavouriteStocksFragment
import com.app.stocks.stock.StockSymbolFragment
import kotlinx.android.synthetic.main.activity_main.*

const val CURR_NAV_ITEM_KEY = "current_navigation_item"

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_stocks -> {
                setFragment(StockSymbolFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_favourites -> {
                setFragment(FavouriteStocksFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_settings -> {
                setFragment(SettingsFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(CURR_NAV_ITEM_KEY, navigation.selectedItemId)
        super.onSaveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        if (savedInstanceState != null && savedInstanceState.containsKey(CURR_NAV_ITEM_KEY)) {
            navigation.selectedItemId = savedInstanceState.getInt(CURR_NAV_ITEM_KEY)
        } else {
            navigation.selectedItemId = R.id.navigation_stocks
        }
    }
}
