package com.elijahhezekiah.lloydsbanktest.presentation.coin_list

import com.elijahhezekiah.lloydsbanktest.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    var coins: List<Coin> = emptyList(),
    val error: String = ""
)
