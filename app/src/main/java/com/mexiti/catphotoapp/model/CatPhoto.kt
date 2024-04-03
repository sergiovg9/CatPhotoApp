package com.mexiti.catphotoapp.model

import kotlinx.serialization.Serializable

@Serializable
data class CatPhoto(
    val id:String,
    val url:String,
    val width: Int,
    val height:Int,
    val author: String,
    val download_url: String
)
