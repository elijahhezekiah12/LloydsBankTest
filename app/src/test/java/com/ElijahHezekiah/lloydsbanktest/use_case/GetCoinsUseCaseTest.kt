package com.ElijahHezekiah.lloydsbanktest.use_case

import com.ElijahHezekiah.lloydsbanktest.Repositories.FakeCoinRepo
import com.ElijahHezekiah.lloydsbanktest.domain.use_case.get_coins.GetCoinsUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetCoinsUseCaseTest {

    private lateinit var  getCoinsUseCase: GetCoinsUseCase
    private lateinit var  fakeCoinRepo: FakeCoinRepo


    @Before
    fun setup(){
        fakeCoinRepo = FakeCoinRepo()
        getCoinsUseCase = GetCoinsUseCase(fakeCoinRepo)
    }


    @Test
    fun `check coins repo is not empty ` (): Unit = runBlocking {
        val coins = getCoinsUseCase().first()
        coins.data?.let { assert(it.isNotEmpty()) }
    }




}