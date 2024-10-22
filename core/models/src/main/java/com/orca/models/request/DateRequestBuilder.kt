package com.orca.models.request

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjusters.*
import java.util.*


object DateRequestBuilder {
    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH)
    private val yearFormatter = DateTimeFormatter.ofPattern("yyyy", Locale.ENGLISH)
    private val formatterResponse = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH)
    private val formatterDisplay = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH)
    private val formatterCalender= DateTimeFormatter.ofPattern("dd\nMMM\nyy", Locale.ENGLISH)



    fun popularLastYearDateParams(): String {
        val fromDate = LocalDateTime.now().minusYears(1)
        return formatter.format(fromDate) + "," + formatter.format(LocalDateTime.now())
    }

    fun latestDateParams(): String {
        val fromDate = LocalDateTime.now().minusMonths(2)
        return formatter.format(fromDate) + "," + formatter.format(LocalDateTime.now())
    }

    fun upcomingDateParams(): String {
        val toDate = LocalDateTime.now().plusYears(1)
        return formatter.format(LocalDateTime.now()) + "," + formatter.format(toDate)
    }

    fun getLastYear(): String = yearFormatter.format(LocalDateTime.now().minusYears(1))

    fun currentWeekDateParams(): String {
        val monday: LocalDate = LocalDate.now().with(previousOrSame(DayOfWeek.MONDAY))
        val sunday: LocalDate = monday.with(nextOrSame(DayOfWeek.SUNDAY))
        return formatter.format(monday) + "," + formatter.format(sunday)
    }

    fun nextWeekDateParams(): String {
        val monday: LocalDate = LocalDate.now().with(next(DayOfWeek.MONDAY))
        val sunday: LocalDate = monday.with(nextOrSame(DayOfWeek.SUNDAY))
        return formatter.format(monday) + "," + formatter.format(sunday)
    }

    fun last30DaysDateParams(): String {
        val fromDate = LocalDateTime.now().minusDays(30)
        return formatter.format(fromDate) + "," + formatter.format(LocalDateTime.now())
    }

    fun currentYearDateParams(): String {
        val firstDay: LocalDate = LocalDate.now().with(firstDayOfYear())
        return formatter.format(firstDay) + "," + formatter.format(LocalDateTime.now())
    }

    fun parseDateForDisplay(dateString: String) :String{
        return try {
            LocalDate.parse(
                dateString ,
                formatterResponse
            ).format( formatterDisplay)
        }catch (e:Exception){
            ""
        }
    }
    fun parseDateForCalender(dateString: String) :String{
        return try {
            LocalDate.parse(
                dateString ,
                formatterResponse
            ).format( formatterCalender)
        }catch (e:Exception){
            ""
        }
    }
}