package org.e2fs4.strategy.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.e2fs4.strategy.domain.models.Product

object VKBViewModel {
    var selectedProduct: Product? by mutableStateOf(null)
}