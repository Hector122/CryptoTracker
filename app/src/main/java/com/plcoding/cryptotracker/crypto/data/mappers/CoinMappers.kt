package com.plcoding.cryptotracker.crypto.data.mappers

import com.plcoding.cryptotracker.crypto.data.networking.dto.CoinDto
import com.plcoding.cryptotracker.crypto.domain.Coin
import kotlin.text.toDoubleOrNull

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        marketCapUsd = marketCapUsd.toDoubleOrNull() ?: 0.0,
        priceUsd = priceUsd.toDoubleOrNull() ?: 0.00,
        changePercent24Hr = changePercent24Hr.toDoubleOrNull() ?: 0.00
    )
}
