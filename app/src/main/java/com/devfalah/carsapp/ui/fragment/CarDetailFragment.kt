package com.devfalah.carsapp.ui.fragment

import android.os.Bundle
import com.devfalah.carsapp.R
import com.devfalah.carsapp.data.models.Car
import com.devfalah.carsapp.databinding.FragmentCarDetailBinding
import com.devfalah.carsapp.ui.base.BaseFragment
import com.devfalah.carsapp.utilities.extention.back
import com.devfalah.carsapp.utilities.extention.cachedNetworkImage
import com.devfalah.carsapp.utilities.extention.navigateAndReplaceTo

class CarDetailFragment : BaseFragment<FragmentCarDetailBinding>() {
    override fun bindingInflater(): FragmentCarDetailBinding =
        FragmentCarDetailBinding.inflate(layoutInflater)


    override fun setup() {
        addCallback()
    }

    private fun addCallback() {
        addBackButtonCallback()
        addBuyButtonCallback()
    }

    private fun addBuyButtonCallback() {
        binding.buyButton.setOnClickListener {
            requireActivity().navigateAndReplaceTo(SuccessFragment())
        }
    }

    private fun addBackButtonCallback() {
        binding.backButton.setOnClickListener {
            requireActivity().back(this@CarDetailFragment)
        }
    }

    override fun onStart() {
        super.onStart()
        val car = getCarFromArguments()
        bindView(car)
    }

    private fun getCarFromArguments(): Car = arguments?.getParcelable(KEY)!!

    private fun bindView(car: Car) {
        binding.apply {
            pageTitle.text = car.name
            carImg.cachedNetworkImage(this.root, car.imageUrl)
            vendorName.text = car.vendorName
            description.text = car.description
            priceValue.text = "${car.price} $"
            speedValue.text = "${car.speed} ${getString(R.string.km_per_hour)}"
            locationValue.text = "${car.country} , ${car.city}"
        }
    }


    companion object {
        fun newInstance(car: Car) = CarDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable(KEY, car)
            }
        }

        private const val KEY = "car"
    }

}

