package com.ElijahHezekiah.lloydsbanktest.use_case

import com.ElijahHezekiah.lloydsbanktest.Repositories.FakeCoinsRepo
import com.ElijahHezekiah.lloydsbanktest.domain.use_case.get_coins.GetCoinsUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetCoinUseCaseTest {

    private lateinit var  getCoinsUseCase: GetCoinsUseCase
    private lateinit var  fakeCoinsRepo: FakeCoinsRepo


    @Before
    fun setup(){
        fakeCoinsRepo = FakeCoinsRepo()
        getCoinsUseCase = GetCoinsUseCase(fakeCoinsRepo)
    }

    @Test
    fun `check coins repo contains BTC` (): Unit = runBlocking {

    }




}