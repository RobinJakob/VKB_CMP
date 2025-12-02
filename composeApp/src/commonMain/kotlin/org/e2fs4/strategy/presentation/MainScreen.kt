package org.e2fs4.strategy.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import vkb_strategypattern.composeapp.generated.resources.Res
import vkb_strategypattern.composeapp.generated.resources.compose_multiplatform
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
                            VKBScreen()
                        }
                    }
                }
            }
        }
    }
}