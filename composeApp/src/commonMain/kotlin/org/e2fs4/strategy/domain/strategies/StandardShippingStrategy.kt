package org.e2fs4.strategy.domain.strategies

class StandardShippingStrategy(
    flatrate: Double = 5.00
): ShippingStrategy {

    override fun CalculateCost(
        orderValue: Double,
        weightInKg: Double
    ): Double {
        TODO("Not yet implemented")
    }

}