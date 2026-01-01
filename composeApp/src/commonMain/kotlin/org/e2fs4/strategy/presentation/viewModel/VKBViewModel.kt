package org.e2fs4.strategy.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import org.e2fs4.strategy.domain.formatting.toCurrencyString
import org.e2fs4.strategy.domain.models.Product
import org.e2fs4.strategy.domain.strategies.ExpressShippingStrategy
import org.e2fs4.strategy.domain.strategies.FreeShippingStrategy
import org.e2fs4.strategy.domain.strategies.ShippingStrategy
import org.e2fs4.strategy.domain.strategies.StandardShippingStrategy

// Die Logik-Klasse, welche von den Screens aufgerufen wird, um die eigentliche Programmlogik auszuführen.
// Bei einer größeren Anwendung würde jeder Screen seine eigene ViewModel-Klasse bekommen
// und es würde Dependency-Injection (z.B. Koin) statt Singleton eingesetzt werden, um ihre Laufzeit zu regulieren.
object VKBViewModel {
    private val allShippingStrategies = listOf(
        StandardShippingStrategy(),
        FreeShippingStrategy(),
        ExpressShippingStrategy()
    )
    var selectedProduct: Product? by mutableStateOf(null)
    var selectedShippingStrategy: ShippingStrategy? by mutableStateOf(null)
    val products = listOf(
        Product(productName = "Smartphone", price = 699.0, weightInKg = 0.5),
        Product(productName = "Standmixer", price = 79.0, weightInKg = 4.5),
        Product(productName = "Waschmaschine", price = 499.0, weightInKg = 80.0)
    )

    fun getAvailableShippingStrategies(product: Product): List<ShippingStrategy> {
        val availableShippingStrategies = mutableListOf<ShippingStrategy>()
        allShippingStrategies.forEach {
            if (it.isAvailable(product.price)) {
                availableShippingStrategies.add(it)
            }
        }
        return availableShippingStrategies
    }


    fun getShippingCostString(strategy: ShippingStrategy, product: Product): AnnotatedString {
        return buildAnnotatedString {
            append("${strategy.getName()}: ")
            if (strategy.strikePrice() > 0.0) {
                withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                    append(strategy.strikePrice().toCurrencyString())
                }
                append(" ")
            }
            append(strategy.calculateCost(product.price, product.weightInKg).toCurrencyString())
        }
    }
}