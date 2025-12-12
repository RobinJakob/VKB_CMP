package org.e2fs4.strategy.domain.strategies

import org.e2fs4.strategy.domain.formatting.toCurrencyString

class ExpressShippingStrategy(
    private val flatRate: Double = 6.00,
    private val costPerKg: Double = 2.00
): ShippingStrategy {
    override fun getName(): String {
        return "Expressversand"
    }

    override fun calculateCost(
        orderValue: Double,
        weightInKg: Double
    ): Double {
        return flatRate + weightInKg / costPerKg
    }

    override fun getDescription(): String {
        return "${flatRate.toCurrencyString()} + ${costPerKg.toCurrencyString()} + " +
                "pro kg Warengewicht für eine schnellere Lieferung, \n" +
                "möglich ab einem Warenwert von 10,00€."
    }

    override fun getETA(): Int {
        return 2
    }
}