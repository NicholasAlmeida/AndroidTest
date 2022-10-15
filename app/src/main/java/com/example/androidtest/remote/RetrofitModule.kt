package com.example.androidtest.remote

import com.fasterxml.jackson.databind.ObjectMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

/**
 * Retrofit module for Hilt usage
 *
 * @author Nicholas Almeida
 */
@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule{
    @Provides
    @Singleton
    fun retrofitProvider(mapper: ObjectMapper): Retrofit {
        val client = OkHttpClient.Builder()
            .addInterceptor {
                it.proceed(
                    it.request()
                        .newBuilder()
                        .addHeader("Authorization", "Client-ID 1ceddedc03a5d71")
                        .build())
            }.build()

        return Retrofit.Builder()
            .baseUrl("https://api.imgur.com/")
            .addConverterFactory(JacksonConverterFactory.create(mapper))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
    }
}