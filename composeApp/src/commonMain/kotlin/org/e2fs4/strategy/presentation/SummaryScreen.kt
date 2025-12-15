package org.e2fs4.strategy.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.e2fs4.strategy.domain.formatting.toCurrencyString
import org.e2fs4.strategy.domain.models.Product
import org.e2fs4.strategy.domain.strategies.StandardShippingStrategy
import org.e2fs4.strategy.presentation.viewModel.VKBViewModel

@Composable
fun SummaryScreen(
    onNavigateNext: () -> Unit,
    onNavigateBack: () -> Unit
) {
    val selectedProduct = VKBViewModel.selectedProduct
        ?: Product("Unbekannt", 0.0, 0.0)
    val selectedShippingStrategy = VKBViewModel.selectedShippingStrategy
        ?: StandardShippingStrategy()
    val shippingCost = selectedShippingStrategy.calculateCost(selectedProduct.price, selectedProduct.weightInKg)
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
                    text = "Bestellübersicht",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainer
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = selectedProduct.productName,
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                text = selectedProduct.price.toCurrencyString(),
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Versand (${selectedShippingStrategy.getName()})",
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                text = shippingCost.toCurrencyString(),
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }

                        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Gesamtsumme",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = (selectedProduct.price + shippingCost).toCurrencyString(),
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }

                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Voraussichtliche Ankunft in ${selectedShippingStrategy.getETA()} Tagen",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    onClick = {
                        onNavigateNext()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Kostenpflichtig bestellen")
                }
            }

            item {
                Button(
                    onClick = {
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