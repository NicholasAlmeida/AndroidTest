package com.example.androidtest.remote

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Retrofit service. Provides functions for Retrofit usage.
 *
 * @author Nicholas Almeida
 */
class RetrofitService
    @Inject constructor(private val retrofit: Retrofit)
    : IRetrofitService {

    override fun <T> getService(serviceClass: Class<T>): T =
        retrofit.create(serviceClass)

    /**
     * Retrofit service module for Hilt usage
     */
    @Module
    @InstallIn(SingletonComponent::class)
    abstract class RetrofitServiceModule{
        @Singleton
        @Binds
        abstract fun makeRetrofitService(retrofitService: RetrofitService): IRetrofitService
    }
}