package com.devfalah.carsapp.data.services

import com.devfalah.carsapp.utilities.Constant
import okhttp3.HttpUrl
import okhttp3.Request

object RequestBuilder {
    fun makeCarsRequest(): Request {
        val url = HttpUrl.Builder().scheme(Constant.SCHEMA).host(Constant.HOST)
            .addPathSegment(Constant.PATH_1ST_PART)
            .addPathSegment(Constant.PATH_2ND_PART)
            .addPathSegment(Constant.PATH_3RD_PART)
            .build()

        return Request.Builder().url(url)
            .build()
    }

}