package com.devfalah.carsapp.data.repository

import com.devfalah.carsapp.data.State
import com.devfalah.carsapp.data.models.Car
import com.devfalah.carsapp.data.services.BaseCarsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


interface CarsRepository {
    fun getCars(): Flow<State<List<Car>>>
}

class CarsRepositoryImp(private val carsService: BaseCarsService) : CarsRepository {
    override fun getCars(): Flow<State<List<Car>>> {
        return flow {
            emit(State.Loading)
            emit(carsService.getCars())
        }.flowOn(Dispatchers.IO)
    }
}