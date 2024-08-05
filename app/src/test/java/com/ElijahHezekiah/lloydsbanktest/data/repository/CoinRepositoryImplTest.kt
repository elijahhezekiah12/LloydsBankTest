package com.elijahHezekiah.lloydsbanktest.data.repository

import com.elijahhezekiah.lloydsbanktest.data.CoinPaprikaApi
import com.elijahhezekiah.lloydsbanktest.data.dto.CoinDetailDto
import com.elijahhezekiah.lloydsbanktest.data.dto.CoinDto
import com.elijahhezekiah.lloydsbanktest.data.dto.Links
import com.elijahhezekiah.lloydsbanktest.data.dto.LinksExtended
import com.elijahhezekiah.lloydsbanktest.data.dto.Stats
import com.elijahhezekiah.lloydsbanktest.data.dto.Tag
import com.elijahhezekiah.lloydsbanktest.data.dto.TeamMember
import com.elijahhezekiah.lloydsbanktest.data.dto.Whitepaper
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



    @Test
    fun  testCoinList_Is_Not_Empty() = runTest {

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

        coEvery { coinPaprikaApi.getCoins() } returns  listOfCoins

        val coinRepo = CoinRepositoryImpl(coinPaprikaApi)

        val result = coinRepo.getCoins()

        Assert.assertEquals(true, result.isNotEmpty())

    }



    @Test
    fun testCoinList_Contains_Btc() = runTest {

        val TeamMember1 = TeamMember(
            "satoshi-nakamoto",
            "Satoshi Nakamoto",
            "Founder"
        )

        val TeamMember2 = TeamMember(
            "wladimir-j-van-der-laan",
            "Wladimir J. van der Laan",
            "Blockchain Developer"
        )

        val TeamMember3 = TeamMember (
            "jonas-schnelli",
            "Jonas Schnelli",
            "Blockchain Developer"
        )

        val TeamMember4 = TeamMember (
            "marco-falke",
            "Marco Falke",
            "Blockchain Developer"

        )

        val teamMemberList = mutableListOf(TeamMember1,TeamMember2,TeamMember3,TeamMember4)

        val explorer = mutableListOf( "https://blockchair.com/bitcoin/?from=coinpaprika",
            "https://blockchain.com/explorer",
            "https://blockstream.info/",
            "https://live.blockcypher.com/btc/",
            "https://btc.cryptoid.info/btc/")

        val facebook = mutableListOf("")
        val reddit = mutableListOf("")
        val source_code = mutableListOf("")
        val website = mutableListOf("")
        val youtube = mutableListOf("")


        val links  = Links(
            explorer,
            facebook,
            reddit,
            source_code,
            website,
            youtube
        )

        val stats  = Stats(
            1,
            1,
            1,
            1
        )

        val linksextended  = LinksExtended(
            stats,
            "explorer",
            ""
        )

        val links_extended = mutableListOf(linksextended)

        val whitepaper = Whitepaper(
            "https://static.coinpaprika.com/storage/cdn/whitepapers/215.pdf",
            "https://static.coinpaprika.com/storage/cdn/whitepapers/217.jpg"
        )

        val tag = Tag(
            12,
            0,"segwit",
            "Segwit"
        )

        val Tags = mutableListOf(tag)


        val btcCoinDetialDto  =  CoinDetailDto(
            "Bitcoin is a cryptocurrency and worldwide payment system. " +
                    "It is the first decentralized digital currency, " +
                    "as the system works without a central bank or single administrator.",
            "Working product",
            "2010-07-17T00:00:00Z",
            true,
            "SHA256",
            "btc-bitcoin",
            true,
            false,
            "2024-07-25T11:59:00Z",
            links,
            links_extended,
            "",
            "Bitcoin",
            true,
            "Decentralized",
            "Proof of Work",
            1,
            "2009-01-03T00:00:00Z",
            "BTC",
            Tags,
            teamMemberList,
            "coin",
            whitepaper

        )
        coEvery { coinPaprikaApi.getCoinById("btc-bitcoin") } returns  btcCoinDetialDto

        val coinRepo = CoinRepositoryImpl(coinPaprikaApi)

        val result = coinRepo.getCoinById("btc-bitcoin")

        Assert.assertEquals(true, result.name == "Bitcoin")



    }


}