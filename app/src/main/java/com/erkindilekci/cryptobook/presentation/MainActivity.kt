package com.erkindilekci.cryptobook.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.erkindilekci.cryptobook.presentation.coin_detail.CoinDetailScreen
import com.erkindilekci.cryptobook.presentation.coin_list.CoinListScreen
import com.erkindilekci.cryptobook.presentation.ui.theme.MyBlack
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MyBlack) {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.CoinListScreen.route
                ) {
                    composable(Screen.CoinListScreen.route) {
                        CoinListScreen(navController)
                    }
                    composable(route = Screen.CoinDetailScreen.route + "/{coinId}") {
                        CoinDetailScreen()
                    }
                }
            }
        }
    }
}
