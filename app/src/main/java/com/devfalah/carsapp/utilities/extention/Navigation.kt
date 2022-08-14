package com.devfalah.carsapp.utilities.extention

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.devfalah.carsapp.R
import com.devfalah.carsapp.utilities.enum.NavigationType

fun FragmentActivity.navigateTo(to: Fragment) {
    changeNavigation(this, NavigationType.Add, to)
}

fun FragmentActivity.navigateAndReplaceTo(to: Fragment){
    changeNavigation(this, NavigationType.Replace, to)
}

fun FragmentActivity.back(to: Fragment) {
    changeNavigation(this, NavigationType.Remove, to)
}

private fun changeNavigation(activity: FragmentActivity, state: NavigationType, to: Fragment) {
    val transaction = activity.supportFragmentManager.beginTransaction()
    when (state) {
        NavigationType.Add -> transaction.add(R.id.home_fragment_container, to)
        NavigationType.Remove -> transaction.remove(to)
        NavigationType.Replace -> transaction.replace(R.id.home_fragment_container, to)
    }
    transaction.addToBackStack(null).commit()
}