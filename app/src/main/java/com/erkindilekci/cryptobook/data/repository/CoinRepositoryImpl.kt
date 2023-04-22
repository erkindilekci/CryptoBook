package com.erkindilekci.cryptobook.data.repository

import com.erkindilekci.cryptobook.data.remote.CoinPaprikaApi
import com.erkindilekci.cryptobook.data.remote.dto.CoinDetailDto
import com.erkindilekci.cryptobook.data.remote.dto.CoinDto
import com.erkindilekci.cryptobook.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: CoinPaprikaApi): CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}