package com.example.androidtest.remote

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Object mapper module for Hilt usage
 *
 * @author Nicholas Almeida
 */
@Module
@InstallIn(SingletonComponent::class)
class ObjectMapperModule {
    @Provides
    @Singleton
    fun objectMapperProvider() = ObjectMapper().registerKotlinModule().apply {
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    }
}