package com.devfalah.carsapp.utilities.extention

import com.google.gson.Gson

inline fun <reified T>String.fromJson():T{
    return Gson().fromJson(this,T::class.java)
}