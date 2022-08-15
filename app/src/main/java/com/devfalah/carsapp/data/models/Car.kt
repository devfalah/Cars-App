package com.devfalah.carsapp.data.models

import com.google.gson.annotations.SerializedName

data class Car(
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("speed")
    val speed: Int,
    @SerializedName("vendor_name")
    val vendorName: String,
)