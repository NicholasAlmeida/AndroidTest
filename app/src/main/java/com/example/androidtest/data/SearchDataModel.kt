package com.example.androidtest.data

/**
 * Search data model. Describes Album body from Imgur API.
 *
 * @author Nicholas Almeida
 *
 * @property id
 * @property title
 * @property description
 * @property datetime
 * @property images
 * @constructor Create empty Search data model
 */
data class SearchDataModel(
    val id: String,
    val title: String?,
    val description: String?,
    val datetime: Long,
    val images: Collection<ImageDataModel>?
)
