package com.xenrath.fruitman_v2.network

import com.xenrath.fruitman_v2.data.ResponseLogin
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiEndpoint {

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("name") name: String,
        @Field("password") password: String
    ): Call<ResponseLogin>
}