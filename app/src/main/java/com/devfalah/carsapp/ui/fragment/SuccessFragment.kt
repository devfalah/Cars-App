package com.devfalah.carsapp.ui.fragment

import com.devfalah.carsapp.databinding.FragmentSuccessBinding
import com.devfalah.carsapp.ui.base.BaseFragment
import com.devfalah.carsapp.utilities.extention.navigateAndReplaceTo

class SuccessFragment : BaseFragment<FragmentSuccessBinding>() {
    override fun bindingInflater(): FragmentSuccessBinding = FragmentSuccessBinding.inflate(layoutInflater)


    override fun setup() {
        addBackToHomeButtonCallback()
    }

    private fun addBackToHomeButtonCallback() {
        binding.backToHome.setOnClickListener{
            requireActivity().navigateAndReplaceTo(HomeFragment())
        }
    }
}