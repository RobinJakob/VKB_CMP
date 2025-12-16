package org.e2fs4.strategy.domain.strategies

open class StandardShippingStrategy(
    protected val flatRate: Double = 5.00
): ShippingStrategy {
    override fun isAvailable(orderValue: Double): Boolean {
        if (orderValue < 100.0) {
            return true
        }
        return false
    }

    override fun getName(): String {
        return "Standardversand"
    }

    override fun calculateCost(
        orderValue: Double,
        weightInKg: Double
    ): Double {
        return flatRate
    }

    override fun getETA(): Int {
        return 3
    }
}

class FreeShippingThresholdStrategy(
): StandardShippingStrategy() {
    override fun isAvailable(orderValue: Double): Boolean {
        if (orderValue >= 100.0) {
            return true
        }
        return false
    }

    override fun calculateCost(
        orderValue: Double,
        weightInKg: Double
    ): Double {
        return 0.0
    }

    override fun strikePrice(): Double = flatRate
}