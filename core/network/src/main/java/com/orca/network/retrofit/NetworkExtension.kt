package com.orca.network.retrofit

import com.orca.network.model.base.ApiFailure
import com.orca.network.model.base.ApiResult
import com.orca.network.model.base.ApiSuccess
import org.json.JSONObject
import retrofit2.Response

suspend fun <T : Any> handleApi(
    errorMessage: String = "Problem Fetching data at the moment!",
    call: suspend () -> Response<T>
): ApiResult<T> {

    try {
        val response = call()
        if (response.isSuccessful) {
            response.body()?.let {
                return ApiSuccess(it)
            }
        }
        response.errorBody()?.let {
            return try {
                val errorString = it.string()
                val errorObject = JSONObject(errorString)
                ApiFailure(errorObject.getString("status_message") ?: errorMessage)
            } catch (ignored: Exception) {
                ApiFailure(ignored.message)
            }
        } ?: return  ApiFailure(null, response.code())
    } catch (e: Exception) {
        return ApiFailure(e.message ?: errorMessage)
    }
}