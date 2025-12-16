package org.e2fs4.strategy.domain.strategies

class ExpressShippingStrategy(
    private val flatRate: Double = 10.00,
    private val costPerKg: Double = 2.00
): ShippingStrategy {
    override fun isAvailable(orderValue: Double): Boolean {
        if (orderValue > flatRate) {
            return true
        }
        return false
    }

    override fun getName(): String {
        return "Expressversand"
    }

    override fun calculateCost(
        orderValue: Double,
        weightInKg: Double
    ): Double {
        return flatRate + weightInKg / costPerKg
    }

    override fun getETA(): Int {
        return 2
    }
}