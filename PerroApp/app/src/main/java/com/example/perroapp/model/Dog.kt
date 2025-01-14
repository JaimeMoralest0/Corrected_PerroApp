package com.example.perroapp.model

data class Dog(
    val name: String,
    val breed: String?,
    val image: Image?
)

data class Image(
    val url: String
)
