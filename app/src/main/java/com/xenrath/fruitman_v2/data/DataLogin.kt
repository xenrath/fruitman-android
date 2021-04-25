package com.xenrath.fruitman_v2.data

import com.google.gson.annotations.SerializedName

data class DataLogin (

    @SerializedName("name") val name: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("phone") val phone: String?,
    @SerializedName("gender") val gender: String?,
    @SerializedName("address") val address: String?,
    @SerializedName("level") val level: String?,
    @SerializedName("status") val status: String?

)