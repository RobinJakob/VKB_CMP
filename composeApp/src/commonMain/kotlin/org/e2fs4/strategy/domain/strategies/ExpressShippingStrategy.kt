package org.e2fs4.strategy.domain.strategies

class ExpressShippingStrategy(
    private val costPerKg: Double = 2.00
): ShippingStrategy {
    override fun calculateCost(
        orderValue: Double,
        weightInKg: Double
    ): Double {
        return weightInKg * costPerKg
    }
}