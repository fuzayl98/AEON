package com.fuzaylofficial.aeon.di.modules

import com.fuzaylofficial.aeon.Constants
import com.fuzaylofficial.aeon.services.LoginService
import com.fuzaylofficial.aeon.services.PaymentsService
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkModule{


    @Provides
    fun bindPaymentsService(retrofit: Retrofit = getRetrofit()): PaymentsService {
        return retrofit.create(PaymentsService::class.java)
    }

    @Provides
    fun bindService(retrofit: Retrofit = getRetrofit()): LoginService {
        return retrofit.create(LoginService::class.java)
    }

    @Provides
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(getOkHttpClient(getOkHttpNetworkInterceptor()))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getOkHttpNetworkInterceptor(): Interceptor {
        return Interceptor { chain ->
            val newRequest =
                chain.request().newBuilder()
                    .addHeader(Constants.HEADER_API_KEY, Constants.API_KEY).addHeader(
                        Constants.HEAD_V,
                        Constants.HEAD_V_KEY).build()
            chain.proceed(newRequest)
        }
    }

    private fun getOkHttpClient(okHttpNetworkInterceptor: Interceptor = getOkHttpNetworkInterceptor()): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(okHttpNetworkInterceptor)
            .build()
    }

}