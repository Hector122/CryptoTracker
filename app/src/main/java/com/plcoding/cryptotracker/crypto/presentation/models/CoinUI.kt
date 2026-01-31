package com.plcoding.cryptotracker.crypto.presentation.models

import androidx.annotation.DrawableRes
import com.plcoding.cryptotracker.core.presentation.util.getDrawableIdForCoin
import com.plcoding.cryptotracker.crypto.domain.Coin
import com.plcoding.cryptotracker.crypto.presentation.coin_detail.DataPoint
import java.text.NumberFormat

data class CoinUI(
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val markerCapUsd: DisplayableNumber,
    val priceUsd: DisplayableNumber,
    val changePercentage24hrs: DisplayableNumber,
    val coinPriceHistory: List<DataPoint> = emptyList(),
    @DrawableRes val iconResId: Int
)

data class DisplayableNumber(
    val value: Double, val formatted: String
)


fun Coin.toCoinUi(): CoinUI {
    return CoinUI(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        markerCapUsd = marketCapUsd.toDisplayableNumber(),
        priceUsd = priceUsd.toDisplayableNumber(),
        changePercentage24hrs = changePercent24Hr.toDisplayableNumber(),
        iconResId = getDrawableIdForCoin(symbol)
    )
}

fun Double.toDisplayableNumber(): DisplayableNumber {
    val formatter = NumberFormat.getNumberInstance(java.util.Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }

    return DisplayableNumber(this, formatter.format(this))
}
