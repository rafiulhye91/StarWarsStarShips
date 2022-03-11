package com.example.starwarsstarships.data.model


import com.google.gson.annotations.SerializedName

data class StarshipsDTO(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<StarshipDTO>
)
