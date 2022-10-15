package com.example.androidtest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import com.example.androidtest.data.ImageDataModel
import com.example.androidtest.domain.IMainDomain
import javax.inject.Inject

/**
 * Main view model. View Model for Main Fragment.
 *
 * @author Nicholas Almeida
 */
@HiltViewModel
class MainViewModel
    @Inject constructor(private val mainDomain: IMainDomain)
    : ViewModel() {

    private val disposables = mutableListOf<Disposable>()
    val images = MutableLiveData<List<ImageDataModel>>()

    /**
     * Request images with Main Domain.
     */
    fun requestImages(){
        mainDomain.requestSearchByTerm("cats", { data ->
            val disp = Single.just(1).observeOn(AndroidSchedulers.mainThread()).subscribe { _->
                val imageList = data.mapNotNull { it.images }.flatten()
                images.value = imageList
            }
            disposables.add(disp)
        })
    }

    override fun onCleared() {
        super.onCleared()

        disposables.forEach { it.dispose() }
        disposables.clear()

        mainDomain.clear()
    }
}