package com.orca.network.model.base



sealed class ApiResult<out t : Any?>
data class Success<out T : Any?>(val data: T?) : ApiResult<T>()
data class Failure(val errorMessage: String?, val errorCode: Int? = null) : ApiResult<Nothing>()

