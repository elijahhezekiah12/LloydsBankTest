package com.ElijahHezekiah.lloydsbanktest.domain.CoinRepository

import com.ElijahHezekiah.lloydsbanktest.data.dto.CoinDetailDto
import com.ElijahHezekiah.lloydsbanktest.data.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}