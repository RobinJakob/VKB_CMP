package org.e2fs4.strategy.domain.strategies

interface ShippingStrategy {
    fun CalculateCost(orderValue: Double, weightInKg: Double): Double
}