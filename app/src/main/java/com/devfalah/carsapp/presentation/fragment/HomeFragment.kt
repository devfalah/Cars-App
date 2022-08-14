package com.devfalah.carsapp.presentation.fragment

import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.devfalah.carsapp.data.State
import com.devfalah.carsapp.data.models.Car
import com.devfalah.carsapp.data.repository.CarsRepositoryImp
import com.devfalah.carsapp.data.services.CarsService
import com.devfalah.carsapp.databinding.FragmentHomeBinding
import com.devfalah.carsapp.presentation.adapter.CarsAdapter
import com.devfalah.carsapp.presentation.base.BaseFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment:BaseFragment<FragmentHomeBinding>() {
    override fun bindingInflater(): FragmentHomeBinding =FragmentHomeBinding.inflate(layoutInflater)



    override fun setup() {
        val carsRepository=CarsRepositoryImp(CarsService)
        lifecycleScope.launch(Dispatchers.IO){
            carsRepository.getCars().collect{
                when(it){
                    is State.Fail -> onResponseFail()
                    State.Loading -> onResponseLoading()
                    is State.Success -> onResponseSuccess(it.data)
                }
            }

        }
    }

    private fun onResponseFail() {

    }

    private fun onResponseLoading() {
        binding.loading.visibility = View.VISIBLE

    }

    private suspend fun onResponseSuccess(cars: List<Car>) {
        Log.e("FALAH_HASSAN",cars.size.toString())
        withContext(Dispatchers.Main){
            val carsAdapter=CarsAdapter(cars)
            binding.carRecyclerView.adapter = carsAdapter
            binding.loading.visibility = View.INVISIBLE

        }




    }
}