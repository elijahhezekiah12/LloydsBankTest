package com.ElijahHezekiah.lloydsbanktest.data.mappers

import com.ElijahHezekiah.lloydsbanktest.data.dto.CoinDetailDto
import com.ElijahHezekiah.lloydsbanktest.data.dto.CoinDto
import com.ElijahHezekiah.lloydsbanktest.domain.model.Coin
import com.ElijahHezekiah.lloydsbanktest.domain.model.CoinDetail

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )
}


fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}