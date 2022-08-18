package com.devfalah.carsapp.ui.interfaces

import com.devfalah.carsapp.data.models.Car

interface ItemListener {
    fun onClickItem(car: Car)
}