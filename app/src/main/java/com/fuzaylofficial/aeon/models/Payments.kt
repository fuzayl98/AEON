package com.fuzaylofficial.aeon.models

data class Payments (
    val success:Boolean,
    val error: LoginResponce.Error,
    val response: List<PaymentsResponse>
){
    data class PaymentsResponse(
        val desc:String,
        val amount:String,
        val currency:String,
        val created:Long
    )
}