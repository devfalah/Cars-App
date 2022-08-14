package com.devfalah.carsapp.utilities.extention

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.cachedNetworkImage(context: View, imageUrl: String) {
    Glide.with(context).load(imageUrl).into(this)
}