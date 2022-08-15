package com.devfalah.carsapp.data.services

import com.devfalah.carsapp.data.State
import com.devfalah.carsapp.data.models.Car
import com.devfalah.carsapp.data.models.CarsModel
import com.devfalah.carsapp.utilities.extention.fromJson
import okhttp3.OkHttpClient

interface BaseCarsService {
    fun getCars(): State<List<Car>>
}

object CarsService : BaseCarsService {
    private val client = OkHttpClient()
    override fun getCars(): State<List<Car>> {
        val response = client.newCall(RequestBuilder.makeCarsRequest()).execute()
        return if (response.isSuccessful) {
            val carsModel = response.body!!.string().fromJson<CarsModel>()
            State.Success(carsModel)

        } else {
            State.Fail(response.message)
        }
    }
}