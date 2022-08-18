package com.devfalah.carsapp.ui

import android.view.LayoutInflater
import com.devfalah.carsapp.databinding.ActivityMainBinding
import com.devfalah.carsapp.ui.base.BaseActivity
import com.devfalah.carsapp.ui.fragment.HomeFragment
import com.devfalah.carsapp.utilities.extention.navigateTo

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val inflate: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate
    override fun setup() {
        navigateTo(HomeFragment())
    }

}