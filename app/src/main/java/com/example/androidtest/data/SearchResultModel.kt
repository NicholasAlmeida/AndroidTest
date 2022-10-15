package com.example.androidtest.data

/**
 * Search result model. Describes Search Result body from Imgur API.
 *
 * @author Nicholas Almeida
 *
 * @property data
 * @property success
 * @property status
 * @constructor Create empty Search result model
 */
data class SearchResultModel(
    val data: Collection<SearchDataModel>,
    val success: Boolean,
    val status: Int
)