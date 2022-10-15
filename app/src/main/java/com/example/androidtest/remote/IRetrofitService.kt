package com.example.androidtest.remote

/**
 * IRetrofit service. Interface for Retrofit service
 *
 * @author Nicholas Almeida
 */
interface IRetrofitService {
    /**
     * Get service for serviceClass
     *
     * @param serviceClass Retrofit Service class model
     * @return The retrofit service
     */
    fun <T> getService(serviceClass: Class<T>): T
}