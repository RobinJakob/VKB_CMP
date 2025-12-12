package org.e2fs4.strategy.domain.strategies

import org.e2fs4.strategy.domain.formatting.toCurrencyString

open class StandardShippingStrategy(
    protected val flatRate: Double = 5.00
): ShippingStrategy {

    override fun getName(): String {
        return "Standardversand"
    }

    override fun calculateCost(
        orderValue: Double,
        weightInKg: Double
    ): Double {
        return flatRate
    }

    override fun getDescription(): String {
        return "5€ Pauschale bis zu einem Warenwert \nvon 100€, danach 0,00€."
    }

    override fun getETA(): Int {
        return 3
    }
}

class FreeShippingThresholdStrategy(
): StandardShippingStrategy() {
    override fun calculateCost(
        orderValue: Double,
        weightInKg: Double
    ): Double {
        return 0.0
    }

    override fun strikePrice(): Double = flatRate
}