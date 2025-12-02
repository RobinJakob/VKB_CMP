package org.e2fs4.strategy.domain.strategies

class StandardShippingStrategy(
    private val flatRate: Double = 5.00
): ShippingStrategy {

    override fun calculateCost(
        orderValue: Double,
        weightInKg: Double
    ): Double {
        return flatRate
    }

}