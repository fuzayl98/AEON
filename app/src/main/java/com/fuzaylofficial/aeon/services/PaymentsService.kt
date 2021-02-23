package com.fuzaylofficial.aeon.services

import com.fuzaylofficial.aeon.models.Payments
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface PaymentsService {
    @GET("payments")
    suspend fun getPayments(@Query("token") token:String?): Payments
}