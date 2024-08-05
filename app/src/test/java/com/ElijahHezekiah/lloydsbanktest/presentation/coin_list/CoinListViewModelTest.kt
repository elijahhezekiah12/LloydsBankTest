package com.elijahHezekiah.lloydsbanktest.presentation.coin_list

import com.elijahhezekiah.lloydsbanktest.common.Resource
import com.elijahhezekiah.lloydsbanktest.data.dto.CoinDto
import com.elijahhezekiah.lloydsbanktest.data.mappers.toCoin
import com.elijahhezekiah.lloydsbanktest.domain.use_case.get_coins.GetCoinsUseCase
import com.elijahhezekiah.lloydsbanktest.presentation.coin_list.CoinListViewModel
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CoinListViewModelTest  {

    @OptIn(DelicateCoroutinesApi::class)
    @ExperimentalCoroutinesApi
    @get:Rule
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")



    @RelaxedMockK
    private lateinit var getSCoinsVM : CoinListViewModel

    private val getCoinsUseCaseMK = mockk<GetCoinsUseCase>()



    @Before
    fun setUp() {

        Dispatchers.setMain(mainThreadSurrogate)

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

        coEvery { getCoinsUseCaseMK.invoke() } returns flowOf(Resource.Success(listOfCoins.map { it.toCoin() }))

        getSCoinsVM = CoinListViewModel(
            getCoinsUseCaseMK
        )

    }


    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }




    @Test
    fun getCoins() = runTest {


        getSCoinsVM.state.value.coins = getCoinsUseCaseMK.invoke().first().data ?: emptyList()

        advanceUntilIdle()

        val coins = getSCoinsVM.state.value.coins

        assert(coins.isNotEmpty())

    }



}