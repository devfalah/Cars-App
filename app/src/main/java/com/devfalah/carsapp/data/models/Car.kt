package com.devfalah.carsapp.data.models

import com.google.gson.annotations.SerializedName

data class Car(
    val city: String,
    val country: String,
    val createdAt: String,
    val description: String,
    val id: Int,
    val imageUrl: String,
    val name: String,
    val price: Int,
    val speed: Int,
    @SerializedName("vendor_name")
    val vendorName: String
)