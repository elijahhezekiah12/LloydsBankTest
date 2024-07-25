package com.ElijahHezekiah.lloydsbanktest.data.repository

import com.ElijahHezekiah.lloydsbanktest.data.CoinPaprikaApi
import com.ElijahHezekiah.lloydsbanktest.data.dto.CoinDetailDto
import com.ElijahHezekiah.lloydsbanktest.data.dto.CoinDto
import com.ElijahHezekiah.lloydsbanktest.domain.CoinRepository.CoinRepository
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