package com.elijahHezekiah.lloydsbanktest.use_case

import com.elijahHezekiah.lloydsbanktest.Repositories.FakeCoinsRepo
import com.elijahhezekiah.lloydsbanktest.common.Resource
import com.elijahhezekiah.lloydsbanktest.data.dto.CoinDetailDto
import com.elijahhezekiah.lloydsbanktest.data.dto.Links
import com.elijahhezekiah.lloydsbanktest.data.dto.LinksExtended
import com.elijahhezekiah.lloydsbanktest.data.dto.Stats
import com.elijahhezekiah.lloydsbanktest.data.dto.Tag
import com.elijahhezekiah.lloydsbanktest.data.dto.TeamMember
import com.elijahhezekiah.lloydsbanktest.data.dto.Whitepaper
import com.elijahhezekiah.lloydsbanktest.data.mappers.toCoinDetail
import com.elijahhezekiah.lloydsbanktest.domain.model.CoinDetail
import com.elijahhezekiah.lloydsbanktest.domain.use_case.get_coin.GetCoinUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetCoinUseCaseTest {

    val  getCoinUseCase = mockk<GetCoinUseCase>()
    private lateinit var  fakeCoinRepo: FakeCoinsRepo


    @Before
    fun setup(){
        fakeCoinRepo = FakeCoinsRepo()
    }



    @Test
    fun `check coins repo contains BTC` (): Unit = runBlocking {

        val listOfBitcoinTagsName = mutableListOf("segwitt",
            "Cryptocurrency",
            "proof of work",
            "Payments",
            "Sha256",
            "Mining",
            "Lightning Network",
            "Layer 1 (L1)",
            "FTX Holdings",
        )

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

        val btcDetail = CoinDetail(
            "btc-bitcoin",
            "Bitcoin",
            "Bitcoin is a cryptocurrency and worldwide payment system. " +
                    "It is the first decentralized digital currency, " +
                    "as the system works without a central bank or single administrator.",
            "BTC",
            1,
            true,
            listOfBitcoinTagsName ,
            teamMemberList

        )


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

        val coinID = "btc-bitcoin"
        coEvery { getCoinUseCase.invoke(coinID) } returns flowOf(Resource.Success( btcCoinDetialDto.toCoinDetail() ))

        val coin = getCoinUseCase(coinID).first().data?.coinId
        assert(coin == "btc-bitcoin")

    }




}