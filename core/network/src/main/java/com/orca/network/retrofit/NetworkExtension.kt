package com.orca.network.retrofit

import com.orca.network.model.base.ApiResult
import com.orca.network.model.base.Failure
import com.orca.network.model.base.Success
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
                return Success(it)
            }
        }
        response.errorBody()?.let {
            return try {
                val errorString = it.string()
                val errorObject = JSONObject(errorString)
                Failure(errorObject.getString("status_message") ?: errorMessage)
            } catch (ignored: Exception) {
                Failure(ignored.message)
            }
        } ?: return  Failure(null, response.code())
    } catch (e: Exception) {
        return Failure(e.message ?: errorMessage)
    }
}