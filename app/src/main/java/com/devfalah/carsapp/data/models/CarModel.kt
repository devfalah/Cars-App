package com.devfalah.carsapp.data.models

import com.google.gson.Gson

class CarsModel : ArrayList<Car>(){
    fun fromJson(jsonString:String):CarsModel{
    return  Gson().fromJson<CarsModel>(jsonString,CarsModel::class.java)
    }
}


