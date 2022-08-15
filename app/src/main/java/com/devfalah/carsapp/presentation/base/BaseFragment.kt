package com.devfalah.carsapp.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    private lateinit var _binding: VB
    abstract fun bindingInflater(): VB
    protected val binding get() = _binding

    abstract fun setup()
    abstract fun addCallback()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = bindingInflater()
        setup()
        addCallback()
        return _binding.root
    }


}