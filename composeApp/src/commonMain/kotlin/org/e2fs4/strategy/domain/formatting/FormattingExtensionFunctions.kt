package org.e2fs4.strategy.domain.formatting

import kotlin.math.roundToInt

fun Double.toCurrencyString(): String {
    val rounded = (this * 100).roundToInt() / 100.0
    val str = rounded.toString()
    val dotIndex = str.indexOf('.')

    var formattedString = if (dotIndex >= 0) {
        val decimals = str.substring(dotIndex + 1)
        if (decimals.length < 2) {
            "${str}0"
        } else {
            str
        }
    } else {
        "$str.00"
    }
    formattedString += "€"
    return formattedString.replace(".", ",")
}