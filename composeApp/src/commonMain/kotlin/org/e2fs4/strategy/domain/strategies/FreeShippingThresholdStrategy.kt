package org.e2fs4.strategy.domain.strategies

class FreeShippingThresholdStrategy(
    private val threshold: Double = 100.00,
    private val fallbackCost: Double = 5.00
): ShippingStrategy {
    override fun calculateCost(
        orderValue: Double,
        weightInKg: Double
    ): Double {
        return if (orderValue >= threshold) 0.0 else fallbackCost
    }
}