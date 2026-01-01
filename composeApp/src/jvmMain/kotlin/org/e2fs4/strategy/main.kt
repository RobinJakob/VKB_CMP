package org.e2fs4.strategy

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

// Der tatsächliche Einstiegspunkt für das JVM Target.
fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "VKB_StrategyPattern",
    ) {
        App()
    }
}