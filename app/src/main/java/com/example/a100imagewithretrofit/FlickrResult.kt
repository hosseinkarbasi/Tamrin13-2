package com.example.a100imagewithretrofit

import com.google.gson.annotations.SerializedName

data class FlickrResult(
    @SerializedName("photos") val photos: Photos,
    val stat: String
)