package com.plcoding.cryptotracker.crypto.domain

import java.time.ZonedDateTime

data class CoinPrice(
    val priceUsd: Double,
    val time: Long,
    val dateTime: ZonedDateTime
)
