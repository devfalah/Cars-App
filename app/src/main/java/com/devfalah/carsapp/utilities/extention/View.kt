package com.devfalah.carsapp.utilities.extention

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.cachedNetworkImage(context: View, imageUrl: String) {
    Glide.with(context).load(imageUrl).into(this)
}
fun View.hide() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}