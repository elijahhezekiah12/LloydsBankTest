package com.elijahhezekiah.lloydsbanktest.presentation.coin_detail

import com.elijahhezekiah.lloydsbanktest.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    var coin: CoinDetail? = null,
    val error: String = ""
)
