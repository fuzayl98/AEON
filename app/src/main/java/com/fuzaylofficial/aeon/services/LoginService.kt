package com.fuzaylofficial.aeon.services

import com.fuzaylofficial.aeon.models.LoginResponce
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginService {
    @FormUrlEncoded
    @POST("login")
    suspend fun getToken(@Field("login") login:String,@Field("password") password:String): LoginResponce
}