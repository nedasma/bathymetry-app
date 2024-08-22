package com.example.bathymetryapp.login.repository

import com.example.bathymetryapp.login.data.model.LoginDetails
import com.example.bathymetryapp.util.ServiceResult

interface LoginRepository {
    suspend fun postLoginDetails(loginDetails: LoginDetails): ServiceResult<String>
}