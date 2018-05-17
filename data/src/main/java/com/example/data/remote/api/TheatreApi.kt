package com.example.data.remote.api

import com.example.data.BuildConfig
import com.example.data.remote.api.util.AuthenticatorInterceptor
import com.example.data.remote.api.util.MoshiConverters
import com.example.data.remote.api.util.RetryAfterInterceptor
import com.example.data.remote.model.EventTypeRemoteModel
import com.serjltt.moshi.adapters.Wrapped
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class TheatreApi(baseUrl: String) : TheatreService {
    companion object {
        private val TIMEOUT = 10L
    }

    private val theatreService: TheatreService

    init {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.BASIC
        val okHttpClient = OkHttpClient.Builder().connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(AuthenticatorInterceptor())
            .addInterceptor(RetryAfterInterceptor())
            .build()
        val moshi = Moshi.Builder().add(Wrapped.ADAPTER_FACTORY)
            .add(MoshiConverters())
            .add(KotlinJsonAdapterFactory())
            .build()
        val retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
        theatreService = retrofit.create(TheatreService::class.java)
    }

    override fun getEventTypes(): Observable<List<EventTypeRemoteModel>> = theatreService.getEventTypes()

    override fun getEvents(type: Int): Observable<List<EventTypeRemoteModel>> = theatreService.getEvents(type)

    override fun getEvent(id: Int): Observable<EventTypeRemoteModel> = theatreService.getEvent(id)
}