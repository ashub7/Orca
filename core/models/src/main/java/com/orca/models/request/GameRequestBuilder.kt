package com.orca.models.request

import com.orca.models.utils.AppConstants

object GameRequestBuilder {
    fun homePopular() = hashMapOf(
        "page" to "1",
        "ordering" to Ordering.ADDED_REVERSE.type
    )

    fun latestRelease(page: Int) = hashMapOf(
        "page" to page.toString(),
        "dates" to DateRequestBuilder.latestDateParams(),
        "ordering" to Ordering.ADDED_REVERSE.type
    )

    fun upcoming(page: Int) = hashMapOf(
        "page" to page.toString(),
        "dates" to DateRequestBuilder.upcomingDateParams(),
        "ordering" to Ordering.RELEASED.type
    )

    fun popularLastYear(page: Int) = hashMapOf(
        "page" to page.toString(),
        "dates" to DateRequestBuilder.popularLastYearDateParams(),
        "ordering" to Ordering.ADDED_REVERSE.type
    )

    fun topRated(page: Int) = hashMapOf(
        "page" to page.toString(),
        "ordering" to Ordering.RATING_REVERSE.type
    )

    fun search(page: Int, term: String) = hashMapOf(
        "page" to page.toString(),
        "search" to term,
        "search_precise" to "true",
        "search_exact" to "true",
        "ordering" to Ordering.ADDED_REVERSE.type
    )

    fun releasedThisWeek(page: Int) = hashMapOf(
        "page" to page.toString(),
        "dates" to DateRequestBuilder.currentWeekDateParams(),
        "ordering" to Ordering.ADDED_REVERSE.type
    )

    fun releasingNextWeek(page: Int) = hashMapOf(
        "page" to page.toString(),
        "dates" to DateRequestBuilder.nextWeekDateParams(),
        "ordering" to Ordering.ADDED_REVERSE.type
    )

    fun releasedLast30Days(page: Int) = hashMapOf(
        "page" to page.toString(),
        "dates" to DateRequestBuilder.last30DaysDateParams(),
        "ordering" to Ordering.ADDED_REVERSE.type
    )

    fun bestOfThisYear(page: Int) = hashMapOf(
        "page" to page.toString(),
        "dates" to DateRequestBuilder.currentYearDateParams(),
        "ordering" to Ordering.ADDED_REVERSE.type
    )

    fun buildWithResource(
        type: String,
        page: Int,
        ordering: Ordering,
        resourceId: Int
    ): HashMap<String, String> {
        val queryMap = hashMapOf(
            "page" to page.toString(),
            "ordering" to ordering.type
        )
        when (type) {
            AppConstants.GENRE -> queryMap["genres"] = resourceId.toString()
            AppConstants.GAME_DEVELOPER -> queryMap["developers"] = resourceId.toString()
            else -> {
                // publisher
                queryMap["publishers"] = resourceId.toString()
            }
        }
        return queryMap
    }


    // https://api.rawg.io/api/games?page=1&ordering=-added&key=151124c54ec54362bf4e5b4f8e89c198
    // Most popular All time

    // Top rated games of all time
    //https://api.rawg.io/api/games?page=1&ordering=-rating&key=151124c54ec54362bf4e5b4f8e89c198
}