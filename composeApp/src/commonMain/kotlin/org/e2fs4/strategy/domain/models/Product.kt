package org.e2fs4.strategy.domain.models

// Das Datenmodell für die Produkte. Durch "data" wird u.a. für jedes Attribut ein Getter und ein Setter generiert.
data class Product(
    val productName: String,
    val price: Double,
    val weightInKg: Double
)