package com.example.androidtest.domain

import com.example.androidtest.data.SearchDataModel

/**
 * IMain domain. Interface for MainDomain
 *
 * @author Nicholas Almeida
 */
interface IMainDomain {
    /**
     * Request Gallery Search by term to Retrofit service.
     *
     * @param term String term used for query on Gallery Search.
     * @param callback Callback function for successful return.
     * @param callbackError Callback function for error.
     */
    fun requestSearchByTerm(term: String,
                            callback: (sensor: Collection<SearchDataModel>) -> Unit,
                            callbackError: (t: Throwable) -> Unit = {})

    /**
     * Clears data on Main Domain.
     */
    fun clear()
}