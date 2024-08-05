package com.ElijahHezekiah.lloydsbanktest.use_case

import com.elijahHezekiah.lloydsbanktest.Repositories.FakeCoinsRepo
import com.elijahhezekiah.lloydsbanktest.common.Resource
import com.elijahhezekiah.lloydsbanktest.data.dto.CoinDto
import com.elijahhezekiah.lloydsbanktest.data.mappers.toCoin
import com.elijahhezekiah.lloydsbanktest.domain.use_case.get_coins.GetCoinsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetCoinsUseCaseTest {


    private val  getCoinsUseCase =  mockk<GetCoinsUseCase>()

    private lateinit var  fakeCoinRepo: FakeCoinsRepo


    @Before
    fun setup(){
        fakeCoinRepo = FakeCoinsRepo()
    }



    @Test
    fun `check coins repo is not empty ` (): Unit = runBlocking {

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

        coEvery { getCoinsUseCase.invoke() } returns flowOf(Resource.Success( listOfCoins.map { it.toCoin() } ))
        val coins = getCoinsUseCase().first().data ?: emptyList()
        assert(coins.isNotEmpty())
    }


}