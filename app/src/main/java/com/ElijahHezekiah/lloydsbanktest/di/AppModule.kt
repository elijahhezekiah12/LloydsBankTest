package com.elijahhezekiah.lloydsbanktest.di

import com.elijahhezekiah.lloydsbanktest.common.Constants
import com.elijahhezekiah.lloydsbanktest.data.CoinPaprikaApi
import com.elijahhezekiah.lloydsbanktest.data.repository.CoinRepositoryImpl
import com.elijahhezekiah.lloydsbanktest.domain.coinRepository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinsApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}