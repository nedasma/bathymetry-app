package com.example.bathymetryapp.util

sealed class ServiceResult<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?): ServiceResult<T>(data)
    class Error<T>(errorMessage: String, data: T? = null): ServiceResult<T>(data, errorMessage)
}