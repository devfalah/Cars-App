package com.devfalah.carsapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devfalah.carsapp.data.models.Car
import com.devfalah.carsapp.databinding.CarItemBinding
import com.devfalah.carsapp.presentation.interfaces.ItemListener
import com.devfalah.carsapp.utilities.extention.cachedNetworkImage


class CarsAdapter(private val items: List<Car>, private val itemListener: ItemListener) :
    RecyclerView.Adapter<CarsAdapter.CarViewHolder>() {


    inner class CarViewHolder(val binding: CarItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        return CarViewHolder(CarItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val currentCar = items[position]
        holder.binding.apply {
            cardView.setOnClickListener {
                itemListener.onClickItem(currentCar)
            }
            carName.text = currentCar.name
            priceValue.text = "${currentCar.price}$"
            locationValue.text = "${currentCar.country} , ${currentCar.city}"
            vendorName.text = currentCar.vendorName
            speedValue.text = "${currentCar.speed} km/h"
            carImg.cachedNetworkImage(this.root, currentCar.imageUrl)
        }

    }

    override fun getItemCount() = items.size

}