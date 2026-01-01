package org.e2fs4.strategy

import androidx.compose.ui.window.ComposeUIViewController

// Der tatsächliche Einstiegspunkt für das iOS Target.
fun MainViewController() = ComposeUIViewController { App() }