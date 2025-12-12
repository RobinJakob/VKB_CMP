package org.e2fs4.strategy.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.e2fs4.strategy.domain.formatting.toCurrencyString
import org.e2fs4.strategy.domain.models.Product
import org.e2fs4.strategy.domain.strategies.ExpressShippingStrategy
import org.e2fs4.strategy.domain.strategies.FreeShippingThresholdStrategy
import org.e2fs4.strategy.domain.strategies.ShippingStrategy
import org.e2fs4.strategy.domain.strategies.StandardShippingStrategy

object VKBViewModel {
    var selectedProduct: Product? by mutableStateOf(null)
    val products = listOf(
        Product(productName = "Smartphone", price = 699.0, weightInKg = 0.5),
        Product(productName = "Standmixer", price = 79.0, weightInKg = 4.5),
        Product(productName = "Waschmaschine", price = 499.0, weightInKg = 80.0)
    )

    fun getAvailableShippingStrategies(product: Product): List<ShippingStrategy> {
        val availableShippingStrategies = mutableListOf<ShippingStrategy>()

        if (product.price >= 10.0) {
            availableShippingStrategies.add(ExpressShippingStrategy())
        }
        if (product.price >= 100.0) {
            availableShippingStrategies.add(FreeShippingThresholdStrategy())
        } else {
            availableShippingStrategies.add(StandardShippingStrategy())
        }

        return availableShippingStrategies
    }


    fun getShippingCostString(strategy: ShippingStrategy, product: Product): String {
        val shippingCostString = if (strategy.strikePrice() == 0.0) {
            "${strategy.getName()}: " +
                    strategy.calculateCost(
                        product.price, product.weightInKg
                    )
                        .toCurrencyString()
        } else {
            val strikePriceString = (strategy.strikePrice().toCurrencyString())
                .map { "$it\u0336" }.joinToString ("")

            "${strategy.getName()}: " +
                    strikePriceString +
                    " ${strategy.calculateCost(product.price, product.weightInKg).toCurrencyString()}"
        }
        return shippingCostString
    }
}