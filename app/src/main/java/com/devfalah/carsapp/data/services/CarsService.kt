package com.devfalah.carsapp.data.services

import android.util.Log
import com.devfalah.carsapp.data.State
import com.devfalah.carsapp.data.models.Car
import com.devfalah.carsapp.data.models.CarsModel
import com.google.gson.Gson
import okhttp3.OkHttpClient

interface BaseCarsService {
    fun getCars(): State<List<Car>>
}

object CarsService : BaseCarsService {
    private val client = OkHttpClient()
    override fun getCars():State<List<Car>> {
        val response = client.newCall(RequestBuilder.makeCarsRequest()).execute()
        return if (response.isSuccessful) {
            Gson().fromJson(response.body?.string(), CarsModel::class.java).run {
                State.Success(this)
            }



        } else {
            State.Fail(response.message)
        }
    }
}