package com.elijahhezekiah.lloydsbanktest.domain.use_case.get_coins

import android.util.Log
import com.elijahhezekiah.lloydsbanktest.common.Resource
import com.elijahhezekiah.lloydsbanktest.data.mappers.toCoin
import com.elijahhezekiah.lloydsbanktest.domain.coinRepository.CoinRepository
import com.elijahhezekiah.lloydsbanktest.domain.model.Coin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
            Log.d("This are  the coin","$coins")
        } catch(e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection."))
        }
    }
}