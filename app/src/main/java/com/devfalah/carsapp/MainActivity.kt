package com.devfalah.carsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.devfalah.carsapp.data.State
import com.devfalah.carsapp.data.repository.CarsRepositoryImp
import com.devfalah.carsapp.data.services.CarsService
import com.devfalah.carsapp.presentation.fragment.HomeFragment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.add(R.id.home_fragment_container, HomeFragment())
        transaction.commit()
    }

}