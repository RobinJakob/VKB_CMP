package org.e2fs4.strategy.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.e2fs4.strategy.presentation.navigation.AppScreen

@Composable
@Preview
fun MainScreen() {
    MaterialTheme {
        var currentScreen by rememberSaveable { mutableStateOf(AppScreen.Selection) }
        Scaffold { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                androidx.compose.animation.Crossfade(targetState = currentScreen) { screen ->
                    when (screen) {
                        AppScreen.Selection -> {
                            SelectionScreen(
                                onNavigateNext = {
                                    currentScreen = AppScreen.VKB
                                }
                            )
                        }
                        AppScreen.VKB -> {
                            VKBScreen(
                                onNavigateNext = {
                                    currentScreen = AppScreen.Summary
                                },
                                onNavigateBack = {
                                    currentScreen = AppScreen.Selection
                                }
                            )
                        }
                        AppScreen.Summary -> {
                            SummaryScreen(
                                onNavigateNext = {
                                    currentScreen = AppScreen.Confirmation
                                },
                                onNavigateBack = {
                                    currentScreen = AppScreen.VKB
                                }
                            )
                        }
                        AppScreen.Confirmation -> {
                            ConfirmationScreen(
                                onNavigateNext = {
                                    currentScreen = AppScreen.Selection
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}