package com.ElijahHezekiah.lloydsbanktest.Repositories

import com.ElijahHezekiah.lloydsbanktest.data.dto.CoinDetailDto
import com.ElijahHezekiah.lloydsbanktest.data.dto.CoinDto
import com.ElijahHezekiah.lloydsbanktest.data.dto.TeamMember
import com.ElijahHezekiah.lloydsbanktest.domain.CoinRepository.CoinRepository
import com.ElijahHezekiah.lloydsbanktest.domain.model.CoinDetail


class FakeCoinsRepo :CoinRepository{

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

    override suspend fun getCoins(): List<CoinDto> {
        return listOfCoins

    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        TODO("Not yet implemented")
    }


}