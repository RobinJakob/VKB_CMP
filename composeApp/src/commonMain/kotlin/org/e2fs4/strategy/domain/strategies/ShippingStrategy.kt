package org.e2fs4.strategy.domain.strategies

// Das Interface, welches alle Strategies implementieren müssen
interface ShippingStrategy {
    fun isAvailable(orderValue: Double): Boolean
    fun getName(): String
    fun calculateCost(orderValue: Double, weightInKg: Double): Double
    fun getETA(): Int
    fun strikePrice(): Double = 0.0
}