package com.erkindilekci.cryptobook.domain.repository

import com.erkindilekci.cryptobook.data.remote.dto.CoinDetailDto
import com.erkindilekci.cryptobook.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}
