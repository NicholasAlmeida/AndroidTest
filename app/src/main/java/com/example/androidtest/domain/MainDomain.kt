package com.example.androidtest.domain

import android.util.Log
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import com.example.androidtest.data.SearchDataModel
import com.example.androidtest.remote.ImageGalleryRetrofitService
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Main domain. Includes Use Cases for functions used by the Main Fragment.
 *
 * @author Nicholas Almeida
 */
class MainDomain
@Inject constructor(private val imageGalleryRetrofitService: ImageGalleryRetrofitService):
    IMainDomain {
    private val disposables = mutableListOf<Disposable>()

    override fun requestSearchByTerm(term: String,
                                     callback: (sensor: Collection<SearchDataModel>) -> Unit,
                                     callbackError: (t: Throwable) -> Unit){
        val disp = imageGalleryRetrofitService.getSearch(term).subscribeOn(Schedulers.io()).subscribe { result ->
            if (!result.isError) {
                result.response()?.body()?.let {
                    callback.invoke(it.data)
                }
            } else {
                result.error()?.let {
                    callbackError.invoke(it)
                }
            }
        }
        disposables.add(disp)
    }

    override fun clear(){
        disposables.forEach { it.dispose() }
        disposables.clear()
    }

    /**
     * Main domain module for Hilt usage.
     */
    @Module
    @InstallIn(SingletonComponent::class)
    abstract class MainDomainModule {
        @Binds
        @Singleton
        abstract fun makeMainDomain(mainDomain: MainDomain): IMainDomain
    }
}