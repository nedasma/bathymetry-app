package com.example.bathymetryapp.util

/**
 * Helper sealed class to wrap up backend responses to improve overall accessibility of [data] together
 * with error handling ([message]s) which could be later displayed in the UI.
 */
sealed class ServiceResult<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?): ServiceResult<T>(data)
    class Error<T>(errorMessage: String, data: T? = null): ServiceResult<T>(data, errorMessage)
}