package com.devfalah.carsapp.presentation.fragment

import android.os.Bundle
import android.widget.Toast
import com.devfalah.carsapp.R
import com.devfalah.carsapp.data.models.Car
import com.devfalah.carsapp.databinding.FragmentCarDetailBinding
import com.devfalah.carsapp.presentation.base.BaseFragment
import com.devfalah.carsapp.utilities.extention.back
import com.devfalah.carsapp.utilities.extention.cachedNetworkImage

class CarDetailFragment : BaseFragment<FragmentCarDetailBinding>() {
    override fun bindingInflater(): FragmentCarDetailBinding =
        FragmentCarDetailBinding.inflate(layoutInflater)


    override fun setup() {
        addCallback()
    }

    override fun onStart() {
        super.onStart()
        val car = arguments?.getParcelable<Car>(KEY)!!
        bindView(car)
    }

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

    private fun addCallback() {
        binding.apply {
            backButton.setOnClickListener {
                requireActivity().back(this@CarDetailFragment)
            }
            buyButton.setOnClickListener {
                showMessage("Buy")
            }
        }
    }

    private fun showMessage(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
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

