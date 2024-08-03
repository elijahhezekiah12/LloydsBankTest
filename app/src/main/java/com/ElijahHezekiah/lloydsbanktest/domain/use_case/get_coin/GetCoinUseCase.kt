package com.elijahhezekiah.lloydsbanktest.domain.use_case.get_coin

import android.util.Log
import com.elijahhezekiah.lloydsbanktest.common.Resource
import com.elijahhezekiah.lloydsbanktest.data.mappers.toCoinDetail
import com.elijahhezekiah.lloydsbanktest.domain.coinRepository.CoinRepository
import com.elijahhezekiah.lloydsbanktest.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
            Log.d("This is  the coin", "$coin")
        } catch(e: HttpException) {
            Log.d("This is  an error,","$e")
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            Log.d("This is  an error,","$e")
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection."))
        }
    }
}