package com.devfalah.carsapp.presentation.fragment

import androidx.lifecycle.lifecycleScope
import com.devfalah.carsapp.data.State
import com.devfalah.carsapp.data.models.Car
import com.devfalah.carsapp.data.repository.CarsRepositoryImp
import com.devfalah.carsapp.data.services.CarsService
import com.devfalah.carsapp.databinding.FragmentHomeBinding
import com.devfalah.carsapp.presentation.adapter.CarsAdapter
import com.devfalah.carsapp.presentation.base.BaseFragment
import com.devfalah.carsapp.utilities.extention.hide
import com.devfalah.carsapp.utilities.extention.show
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun bindingInflater(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)

    private val carsRepository = CarsRepositoryImp(CarsService)


    override fun setup() {
        getCars()


    }

    private fun getCars() {
        lifecycleScope.launch(Dispatchers.Main) {
            carsRepository.getCars().collect(::onGetResponse)
        }
    }

    private fun onGetResponse(state: State<List<Car>>) {
        when (state) {
            is State.Fail -> onResponseFail()
            State.Loading -> onResponseLoading()
            is State.Success -> onResponseSuccess(state.data)
        }
    }

    private fun onResponseSuccess(cars: List<Car>) {
        binding.loading.hide()
        val carsAdapter = CarsAdapter(cars)
        binding.carRecyclerView.adapter = carsAdapter
    }

    private fun onResponseLoading() {
        binding.loading.show()
    }

    private fun onResponseFail() {

    }


}