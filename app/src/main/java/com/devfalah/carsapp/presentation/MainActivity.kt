package com.devfalah.carsapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.devfalah.carsapp.databinding.ActivityMainBinding
import com.devfalah.carsapp.presentation.base.BaseActivity
import com.devfalah.carsapp.presentation.fragment.HomeFragment
import com.devfalah.carsapp.utilities.extention.navigateTo

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val inflate: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate
    override fun setup() {
        navigateTo(HomeFragment())
    }

}