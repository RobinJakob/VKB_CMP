package org.e2fs4.strategy.domain.strategies

// Die StandardShippingStrategy, von welcher die FreeShippingStrategy erbt (deswegen hier "open")
open class StandardShippingStrategy(
    protected val flatRate: Double = 5.0
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

// Die FreeShippingStrategy, die von StandardShippingStrategy erbt
class FreeShippingStrategy(): StandardShippingStrategy() {
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