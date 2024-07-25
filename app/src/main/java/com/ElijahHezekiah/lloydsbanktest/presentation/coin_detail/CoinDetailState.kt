package com.ElijahHezekiah.lloydsbanktest.presentation.coin_detail

import com.ElijahHezekiah.lloydsbanktest.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
