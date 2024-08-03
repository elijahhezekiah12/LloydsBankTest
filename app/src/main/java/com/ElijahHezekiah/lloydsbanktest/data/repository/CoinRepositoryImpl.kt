package com.elijahhezekiah.lloydsbanktest.data.repository

import com.elijahhezekiah.lloydsbanktest.data.CoinPaprikaApi
import com.elijahhezekiah.lloydsbanktest.data.dto.CoinDetailDto
import com.elijahhezekiah.lloydsbanktest.data.dto.CoinDto
import com.elijahhezekiah.lloydsbanktest.domain.coinRepository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}