package com.devfalah.carsapp.data.services

import com.devfalah.carsapp.utilities.Constant
import okhttp3.HttpUrl
import okhttp3.Request

object RequestBuilder {
    fun makeCarsRequest(): Request {
        val url = HttpUrl.Builder().scheme(Constant.SCHEMA).host(Constant.HOST)
            .addPathSegment(Constant.FIRST_PATH)
            .addPathSegment(Constant.SECOND_PATH)
            .addPathSegment(Constant.THIRD_PATH)
            .build()

        return Request.Builder().url(url)
            .build()
    }

}