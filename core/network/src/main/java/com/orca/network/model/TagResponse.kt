package com.orca.network.model

data class TagResponse(
    val id: Int,
    val name: String,
    val slug: String,
    val gameCount: Int,
    val imageBackgroundURL: String,
    val language: String,
    val description: String
)