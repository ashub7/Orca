package com.orca.network.model.base



sealed class ApiResult<out t : Any?>
data class ApiSuccess<out T : Any?>(val data: T?) : ApiResult<T>()
data class ApiFailure(val errorMessage: String?, val errorCode: Int? = null) : ApiResult<Nothing>()

