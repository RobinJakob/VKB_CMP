package org.e2fs4.strategy.domain.models

import org.e2fs4.strategy.domain.strategies.ShippingStrategy

class Order(
    defaultStrategy: ShippingStrategy
) {
    var shippingStrategy: ShippingStrategy = defaultStrategy
        private set
    var orderValue: Double = 0.0
    var weightInKg: Double = 0.0

    fun calculateShipping(): Double {
        return shippingStrategy.calculateCost(orderValue, weightInKg)
    }
}