package org.e2fs4.strategy

import androidx.compose.runtime.*
import org.e2fs4.strategy.presentation.screens.MainScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

// Der einheitliche Einstiegspunkt für alle Plattformen.
// Der einzige UI-Code, der vor diesem hier ausgeführt werden kann,
// ist der in den plattformspezifischen Main-Packages
// (androidMain, iosMain, jvmMain, jsMain, wasmJsMain, webMain).
@Composable
@Preview
fun App() {
    MainScreen()
}

/*

Allgemein zu KMP:
* Mit der Annotation @Composable wird angegeben, dass eine Funktion eine UI-Komponente darstellt (Rückgabetyp: Unit, wäre Null in C#).
* In der Leiste ganz oben in Android Studio kann das gewünschte App-Target (die Zielplattform)
  und das entsprechende Gerät ausgewählt werden, auf dem die App laufen soll.
* Das KMP-Framework kompiliert jede Plattform nativ:
    - Android kompiliert in Kotlin
    - iOS kompiliert in Objective-C
    - JVM (Desktop mit Windows, Linux und Mac) kompiliert in Kotlin in der Java Virtual Machine
    - JS kompiliert in JavaScript
    - WasmJS kompiliert in WebAssembly
* Die Projektstruktur ist folgende:
    - Der Haupteinstiegspunkt ist die Funktion in dieser Datei (fun App() in App.kt)
    - Presentation Package: Sämtliche UI. Logik darf hier nur durch ViewModels ausgeführt werden.
      Darf auf Domain zugreifen.
    - Data Package: Sämtliche Datenbank-Anbindungen, API-Calls und andere externe Anbindungen.
      Darf auf Domain zugreifen.
    - Domain Package: Datenmodelle und universelle Funktionen, welche keine Zustände und keine Dependencies haben.
      Sollte keine Dependencies haben und entsprechend auch auf nichts außer sich selbst zugreifen.
    - DI Package: Initialisierung und Konfiguration von Dependency Injection.
      Darf auf Domain zugreifen.

 */