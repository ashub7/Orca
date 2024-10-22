package com.orca.models.request

enum class Ordering(val type:String) {
    NAME("name"),
    RELEASED("released"),
    ADDED("added"),
    CREATED("created"),
    UPDATED("updated"),
    RATING("rating"),
    METACRITIC("metacritic"),
    NAME_REVERSE("-name"),
    RELEASED_REVERSE("-released"),
    ADDED_REVERSE("-added"),
    CREATED_REVERSE("-created"),
    UPDATED_REVERSE("-updated"),
    RATING_REVERSE("-rating"),
    METACRITIC_REVERSE("-metacritic")
}
