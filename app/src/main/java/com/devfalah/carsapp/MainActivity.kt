package com.devfalah.carsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devfalah.carsapp.data.services.CarsService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onStart() {
        super.onStart()
        CarsService.getCars()
    }
}