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
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.e2fs4.strategy.presentation.viewModel.VKBViewModel

@Composable
fun ConfirmationScreen(
    onNavigateNext: () -> Unit
) {
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
                    text = "Vielen Dank!",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
            }

            item {
                Text(
                    text = "Ihre Bestellung wurde erfolgreich aufgegeben.",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            item {
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    onClick = {
                        VKBViewModel.selectedProduct = null
                        VKBViewModel.selectedShippingStrategy = null
                        onNavigateNext()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Abschließen"
                    )
                }
            }
        }
    }
}