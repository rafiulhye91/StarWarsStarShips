package com.example.starwarsstarships.domain.model

data class Starship(
    val cargoCapacity: String,
    val consumables: String,
    val costInCredits: String,
    val created: String,
    val crew: String,
    val edited: String,
    val hyperdriveRating: String,
    val length: String,
    val mGLT: String,
    val manufacturer: String,
    val maxAtmospheringSpeed: String,
    val model: String,
    val name: String,
    val passengers: String,
    val pilots: List<String>,
    val starshipClass: String
) {

}