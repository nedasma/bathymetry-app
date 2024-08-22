package com.example.bathymetryapp.login.data.model

import androidx.room.Entity
import com.example.bathymetryapp.bathymetry.data.model.Scan
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "loginDetails")
data class LoginResponse(
    val login: LoginToken,
    val scans: List<Scan>
)
