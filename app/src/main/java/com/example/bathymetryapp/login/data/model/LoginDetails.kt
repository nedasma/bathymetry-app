package com.example.bathymetryapp.login.data.model

import kotlinx.serialization.Serializable

@Serializable
data class LoginDetails(
    val email: String,
    val password: String
)
