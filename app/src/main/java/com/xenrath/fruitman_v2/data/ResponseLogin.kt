package com.xenrath.fruitman_v2.data

import com.google.gson.annotations.SerializedName

data class ResponseLogin (

    @SerializedName("status") val status: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("user") val user: DataLogin?

)