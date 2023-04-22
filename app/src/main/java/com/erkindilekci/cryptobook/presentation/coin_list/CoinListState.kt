package com.erkindilekci.cryptobook.presentation.coin_list

import com.erkindilekci.cryptobook.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
