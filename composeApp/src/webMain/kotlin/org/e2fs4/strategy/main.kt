package org.e2fs4.strategy

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport

// Der tatsächliche Einstiegspunkt für den HTML und CSS Teil der Web Targets (JS und WasmJS).
// Der tatsächliche Einstiegspunkt der Web Targets kann optional in ihren jeweiligen Main Packages definiert werden.
@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport {
        App()
    }
}