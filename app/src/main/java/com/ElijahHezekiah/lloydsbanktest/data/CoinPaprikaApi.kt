package com.elijahhezekiah.lloydsbanktest.data

import com.elijahhezekiah.lloydsbanktest.data.dto.CoinDetailDto
import com.elijahhezekiah.lloydsbanktest.data.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {


    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}