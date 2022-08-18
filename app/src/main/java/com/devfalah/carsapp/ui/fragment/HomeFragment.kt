package com.devfalah.carsapp.ui.fragment

import androidx.lifecycle.lifecycleScope
import com.devfalah.carsapp.data.State
import com.devfalah.carsapp.data.models.Car
import com.devfalah.carsapp.data.repository.CarsRepositoryImp
import com.devfalah.carsapp.data.services.CarsService
import com.devfalah.carsapp.databinding.FragmentHomeBinding
import com.devfalah.carsapp.ui.adapter.CarsAdapter
import com.devfalah.carsapp.ui.base.BaseFragment
import com.devfalah.carsapp.ui.interfaces.ItemListener
import com.devfalah.carsapp.utilities.extention.hide
import com.devfalah.carsapp.utilities.extention.navigateTo
import com.devfalah.carsapp.utilities.extention.show
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment<FragmentHomeBinding>(), ItemListener {
    override fun bindingInflater(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)

    private val carsRepository = CarsRepositoryImp(CarsService)

    override fun setup() {
        getCars()
        addTryAgainButtonCallback()
    }


    private fun addTryAgainButtonCallback() {
        binding.tryAgainButton.setOnClickListener {
            getCars()
        }
    }

    private fun getCars() {
        val carsFlow=carsRepository.getCars()
        lifecycleScope.launch(Dispatchers.Main) {
           carsFlow.collect(::onGetResponse)
        }
    }

    private fun onGetResponse(state: State<List<Car>>) {
        when (state) {
            is State.Fail -> onResponseFail(state.message)
            State.Loading -> onResponseLoading()
            is State.Success -> onResponseSuccess(state.data)
        }
    }

    private fun onResponseSuccess(cars: List<Car>) {
        setupCarsAdapter(cars)
        hideLoadingAndHideErrorView()
    }

    private fun onResponseLoading() {
        showLoadingAndHideErrorView()
    }

    private fun onResponseFail(message: String) {
        hideLoadingAndShowErrorView()
    }

    override fun onClickItem(car: Car) {
        requireActivity().navigateTo(CarDetailFragment.newInstance(car))
    }

    private fun setupCarsAdapter(cars: List<Car>) {
        val carsAdapter = CarsAdapter(cars, this)
        binding.carRecyclerView.adapter = carsAdapter
    }

    private fun hideLoadingAndHideErrorView() {
        binding.apply {
            errorView.hide()
            loading.hide()
        }
    }

    private fun showLoadingAndHideErrorView() {
        binding.apply {
            errorView.hide()
            loading.show()
        }
    }

    private fun hideLoadingAndShowErrorView() {
        binding.apply {
            loading.hide()
            errorView.show()
        }
    }


}