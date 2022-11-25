package com.example.salttechnicaltest.utils

import retrofit2.Response

suspend fun <T> Response<T>.onSuccessOrError(
    invokeSuccess: (data: T) -> Unit,
    invokeError: (String) -> Unit,
    invokeUnathorized: suspend () -> Unit ={},
    errorMsg: String = ""
) {
    if (this.code() == 200) {
        this.body()?.let { invokeSuccess(it) }
    } else {
        if (this.code() == 401) invokeUnathorized()

        if (errorMsg.isEmpty()) {
            this.errorBody()?.let {
                invokeError(it.string())
            } ?: invokeError("[errorCode=${this.code()},message=${this.message()}]")
        } else
            invokeError(errorMsg)
    }
}