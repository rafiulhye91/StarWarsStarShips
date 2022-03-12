package com.example.starwarsstarships.data.model


import com.example.starwarsstarships.domain.model.Starship
import com.google.gson.annotations.SerializedName

data class StarshipDTO(
    @SerializedName("cargo_capacity")
    val cargoCapacity: String,
    @SerializedName("consumables")
    val consumables: String,
    @SerializedName("cost_in_credits")
    val costInCredits: String,
    @SerializedName("created")
    val created: String,
    @SerializedName("crew")
    val crew: String,
    @SerializedName("edited")
    val edited: String,
    @SerializedName("films")
    val films: List<String>,
    @SerializedName("hyperdrive_rating")
    val hyperdriveRating: String,
    @SerializedName("length")
    val length: String,
    @SerializedName("MGLT")
    val mGLT: String,
    @SerializedName("manufacturer")
    val manufacturer: String,
    @SerializedName("max_atmosphering_speed")
    val maxAtmospheringSpeed: String,
    @SerializedName("model")
    val model: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("passengers")
    val passengers: String,
    @SerializedName("pilots")
    val pilots: List<String>,
    @SerializedName("starship_class")
    val starshipClass: String,
    @SerializedName("url")
    val url: String
){
    fun toStarship():Starship{
        return Starship(
            cargoCapacity = this.cargoCapacity,
            consumables = this.consumables,
            costInCredits = this.costInCredits,
            created= this.created,
            crew = this.crew,
            edited = this.edited,
            hyperdriveRating = this.hyperdriveRating,
            length = this.length,
            mGLT = this.mGLT,
            manufacturer = this.manufacturer,
            maxAtmospheringSpeed = this.maxAtmospheringSpeed,
            model = this.model,
            name = this.name,
            passengers = this.passengers,
            pilots = this.pilots,
            starshipClass = this.starshipClass
        )
    }
}
