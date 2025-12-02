package org.e2fs4.strategy.domain.strategies

fun interface ShippingStrategy {
    fun calculateCost(orderValue: Double, weightInKg: Double): Double
}