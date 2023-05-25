package com.erkindilekci.cryptobook.presentation.coin_detail

import com.erkindilekci.cryptobook.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
