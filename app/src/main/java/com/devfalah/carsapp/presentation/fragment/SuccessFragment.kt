package com.devfalah.carsapp.presentation.fragment

import com.devfalah.carsapp.databinding.FragmentSuccessBinding
import com.devfalah.carsapp.presentation.base.BaseFragment
import com.devfalah.carsapp.utilities.extention.back
import com.devfalah.carsapp.utilities.extention.navigateAndReplaceTo

class SuccessFragment : BaseFragment<FragmentSuccessBinding>() {
    override fun bindingInflater(): FragmentSuccessBinding = FragmentSuccessBinding.inflate(layoutInflater)

    override fun setup() {

    }

    override fun addCallback() {
        addBackToHomeButtonCallback()
    }

    private fun addBackToHomeButtonCallback() {
        binding.backToHome.setOnClickListener{
            requireActivity().navigateAndReplaceTo(HomeFragment())
        }
    }
}