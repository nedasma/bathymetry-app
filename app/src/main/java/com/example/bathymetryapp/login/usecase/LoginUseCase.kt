package com.example.bathymetryapp.login.usecase

import com.example.bathymetryapp.login.data.model.LoginDetails
import com.example.bathymetryapp.login.repository.LoginRepository
import com.example.bathymetryapp.util.ServiceResult
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: LoginRepository
) {
    suspend operator fun invoke(email: String, password: String): ServiceResult<String> {
        return repository.postLoginDetails(
            LoginDetails(
                email = email,
                password = password
            )
        )
    }
}