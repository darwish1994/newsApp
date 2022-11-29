package com.link.newsapp.network


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okio.IOException
import retrofit2.HttpException

interface NetworkRemoteServiceCall {

    suspend fun <T> safeApiCallGeneric(apiCall: suspend () -> T): Resource<T> =
        withContext(Dispatchers.IO) {
            try {
                // invoke suspend service method
                val response = apiCall.invoke()

                Resource.Success(response)
            } catch (throwable: Exception) {
                when (throwable) {
                    is NetworkInterceptor.NoInternetConnection, is IOException -> Resource.Error("No Internet Connection", throwable)
                    is HttpException -> Resource.Error(throwable.message(), throwable)
                    else -> Resource.Error("SomeTHING Wrong try again",throwable)

                }
            }
        }
}