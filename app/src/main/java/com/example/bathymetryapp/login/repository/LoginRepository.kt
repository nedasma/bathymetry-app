package com.example.bathymetryapp.login.repository

import com.example.bathymetryapp.login.data.model.LoginDetails
import com.example.bathymetryapp.util.ServiceResult

interface LoginRepository {
    /**
     * Takes [loginDetails] and POSTs them to the backend endpoint. Also saves returned data
     * (login token and scans) to the local database.
     *
     * Returns a ServiceResult containing the login token as a string.
     */
    suspend fun postLoginDetails(loginDetails: LoginDetails): ServiceResult<String>
}