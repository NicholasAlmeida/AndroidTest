package com.example.androidtest.data

/**
 * Image data model. Describes Image body from Imgur API.
 *
 * @author Nicholas Almeida
 *
 * @property id
 * @property title
 * @property description
 * @property datetime
 * @property type
 * @property animated
 * @property width
 * @property height
 * @property size
 * @property link
 * @constructor Create empty Image data model
 */
data class ImageDataModel(
    val id: String,
    val title: String?,
    val description: String?,
    val datetime: Long,
    val type: String,
    val animated: Boolean,
    val width: Int,
    val height: Int,
    val size: Int,
    val link: String
)
