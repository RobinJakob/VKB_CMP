package org.e2fs4.strategy.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import org.e2fs4.strategy.domain.models.Product
import org.e2fs4.strategy.presentation.components.RadioButtonRow
import org.e2fs4.strategy.presentation.viewModel.VKBViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun VKBScreen(
    onNavigateNext: () -> Unit,
    onNavigateBack: () -> Unit
) {
    val selectedProduct = VKBViewModel.selectedProduct
        ?: Product("Unbekannt", 0.0, 0.0)
    val shippingStrategies = VKBViewModel.getAvailableShippingStrategies(selectedProduct)
    var currentSelection by remember { mutableStateOf(shippingStrategies.first()) }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = Modifier
                .widthIn(min = 250.dp, max = 400.dp)
                .wrapContentHeight()
                .selectableGroup()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Text(
                    text = "Versandkostenberechnung",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
            }

            items(shippingStrategies) { strategy ->
                RadioButtonRow(
                    content = {
                        Text(text = VKBViewModel.getShippingCostString(strategy, selectedProduct))
                    },
                    isSelected = (strategy == currentSelection),
                    onSelect = { currentSelection = strategy }
                )
            }

            item {
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    onClick = {
                        VKBViewModel.selectedShippingStrategy = currentSelection
                        onNavigateNext()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Auswahl bestätigen")
                }
            }

            item {
                Button(
                    onClick = {
                        VKBViewModel.selectedShippingStrategy = null
                        onNavigateBack()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Zurück")
                }
            }
        }
    }
}