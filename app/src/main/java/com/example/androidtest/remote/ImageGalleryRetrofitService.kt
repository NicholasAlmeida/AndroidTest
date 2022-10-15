package com.example.androidtest.remote

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.Single
import com.example.androidtest.data.SearchResultModel
import retrofit2.adapter.rxjava2.Result
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

/**
 * Image gallery retrofit service.
 *
 * @author Nicholas Almeida
 */
interface ImageGalleryRetrofitService {
    /**
     * Function for Gallery Search GET request.
     *
     * @param term String term used for query.
     * @return Single object to be subscribed for request result.
     */
    @GET("3/gallery/search/")
    fun getSearch(@Query("q") term: String): Single<Result<SearchResultModel>>

    /**
     * Image gallery retrofit module for Hilt usage
     */
    @Module
    @InstallIn(SingletonComponent::class)
    class ImageGalleryRetrofitModule{
        @Provides
        @Singleton
        fun imageGalleryRetrofitService(retrofitService: IRetrofitService) =
            retrofitService.getService(ImageGalleryRetrofitService::class.java)
    }
}