package com.ElijahHezekiah.lloydsbanktest.use_case

import com.ElijahHezekiah.lloydsbanktest.Repositories.FakeCoinsRepo
import com.ElijahHezekiah.lloydsbanktest.domain.use_case.get_coins.GetCoinsUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetCoinsUseCaseTest {

    private lateinit var  getCoinsUseCase: GetCoinsUseCase
    private lateinit var  fakeCoinRepo: FakeCoinsRepo


    @Before
    fun setup(){
        fakeCoinRepo = FakeCoinsRepo()
        getCoinsUseCase = GetCoinsUseCase(fakeCoinRepo)
    }


    @Test
    fun `check coins repo is not empty ` (): Unit = runBlocking {
        val coins = getCoinsUseCase().first()
        coins.data?.let { assert(it.isNotEmpty()) }
    }




}