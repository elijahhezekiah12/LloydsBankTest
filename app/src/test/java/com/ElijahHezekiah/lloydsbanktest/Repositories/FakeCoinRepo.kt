package com.ElijahHezekiah.lloydsbanktest.Repositories

import com.ElijahHezekiah.lloydsbanktest.data.dto.CoinDetailDto
import com.ElijahHezekiah.lloydsbanktest.data.dto.CoinDto
import com.ElijahHezekiah.lloydsbanktest.domain.CoinRepository.CoinRepository
import com.ElijahHezekiah.lloydsbanktest.presentation.coin_detail.CoinDetailState


class FakeCoinRepo :CoinRepository{

    val btc  = CoinDto( "btc-bitcoin",
     true,
    false,
    "Bitcoin",
    1,
    "BTC",
     "coin")

    val eth  = CoinDto( "eth-ethereum",
        true,
        false,
        "Ethereum",
        2,
        "ETH",
        "coin")


    val USDT  = CoinDto( "usdt-tether",
        true,
        false,
        "Tether",
        3,
        "ETH",
        "token")


    val Binance  = CoinDto( "bnb-binance-coin",
        true,
        false,
        "Binance Coin",
        4,
        "BNB",
        "coin")


    val Solana  = CoinDto( "sol-solana",
        true,
        false,
        "Solana",
        5,
        "SOL",
        "coin")




    val listOfCoins = mutableListOf<CoinDto>(btc,eth,USDT,Binance,Solana)


    val listOfCoinDetailDto = mutableListOf<CoinDetailState>()



    override suspend fun getCoins(): List<CoinDto> {
        return listOfCoins

    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {


        return TODO("Provide the return value")
    }
}