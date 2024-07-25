package com.ElijahHezekiah.lloydsbanktest.di

import com.ElijahHezekiah.lloydsbanktest.common.Constants
import com.ElijahHezekiah.lloydsbanktest.data.CoinPaprikaApi
import com.ElijahHezekiah.lloydsbanktest.data.repository.CoinRepositoryImpl
import com.ElijahHezekiah.lloydsbanktest.domain.CoinRepository.CoinRepository
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
    fun provideBooksApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideBookRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}