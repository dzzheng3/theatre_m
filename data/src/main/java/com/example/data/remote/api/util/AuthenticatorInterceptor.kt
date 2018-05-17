package com.example.data.remote.api.util

import com.example.data.BuildConfig
import io.reactivex.exceptions.Exceptions
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class AuthenticatorInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val currentRequest = chain.request()
        val newRequest = currentRequest.newBuilder().header("Api-Key", BuildConfig.API_KEY)
            .header("Content-Type", "application/json")
            .build()
        try {
            return chain.proceed(newRequest)
        } catch (e: IOException) {
            throw Exceptions.propagate(e)
        }
    }
}