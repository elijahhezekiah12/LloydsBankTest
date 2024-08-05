package com.elijahHezekiah.lloydsbanktest.data.repository

import com.elijahhezekiah.lloydsbanktest.data.CoinPaprikaApi
import com.elijahhezekiah.lloydsbanktest.data.repository.CoinRepositoryImpl
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CoinRepositoryImplTest {

    @MockK
    lateinit var coinPaprikaApi: CoinPaprikaApi

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun testEmptyCoinList() = runTest {

        coEvery { coinPaprikaApi.getCoins() } returns emptyList()

        val coinRepo = CoinRepositoryImpl(coinPaprikaApi)

        val result = coinRepo.getCoins()

        Assert.assertEquals(true, result.isEmpty() )


    }


}