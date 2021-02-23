package com.fuzaylofficial.aeon.models


data class LoginResponce (
    val success:Boolean,
    val response: Response,
    val error: Error
)
{
    data class Response(
        val token:String
    )

    data class Error(
        val error_code:String,
        val error_msg:String
    )

}