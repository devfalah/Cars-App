package com.devfalah.carsapp.presentation.interfaces

import com.devfalah.carsapp.data.models.Car

interface ItemListener {
    fun onClickItem(car: Car)
}