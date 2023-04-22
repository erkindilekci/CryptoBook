package com.erkindilekci.cryptobook.domain.use_case.get_coin

import com.erkindilekci.cryptobook.common.Resource
import com.erkindilekci.cryptobook.data.remote.dto.toCoin
import com.erkindilekci.cryptobook.data.remote.dto.toCoinDetail
import com.erkindilekci.cryptobook.domain.model.CoinDetail
import com.erkindilekci.cryptobook.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An Unexpected Error Occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection"))
        }
    }
}