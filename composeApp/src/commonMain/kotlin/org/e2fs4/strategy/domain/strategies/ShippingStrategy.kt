package org.e2fs4.strategy.domain.strategies

interface ShippingStrategy {
    fun getName(): String
    fun calculateCost(orderValue: Double, weightInKg: Double): Double
    fun getDescription(): String
    fun getETA(): Int
    fun strikePrice(): Double = 0.0
}