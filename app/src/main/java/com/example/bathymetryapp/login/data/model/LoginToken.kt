package com.example.bathymetryapp.login.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "loginToken")
data class LoginToken(
    @PrimaryKey
    val token: String
)
