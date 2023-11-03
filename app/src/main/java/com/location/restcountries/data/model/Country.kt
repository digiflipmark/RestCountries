package com.location.restcountries.data.model

import com.google.gson.annotations.SerializedName

data class Country(
    @field:SerializedName("name")
    val name: Name,
    @field:SerializedName("flags")
    val flags: Flags,
    @field:SerializedName("subregion")
    val subregion: String,
    @field:SerializedName("languages")
    val languages: Languages,
    @field:SerializedName("borders")
    val borders: List<String>,
    @field:SerializedName("population")
    val population: Int

)

data class Name(

    @field:SerializedName("common")
    val common: String,

    @field:SerializedName("official")
    val official: String
)

data class Flags(

    @field:SerializedName("svg")
    val svg: String,

    @field:SerializedName("png")
    val png: String,

    @field:SerializedName("alt")
    val alt: String
)

data class Languages(

    @field:SerializedName("de")
    val de: String
)

