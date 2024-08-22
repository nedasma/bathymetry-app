package com.example.bathymetryapp.bathymetry.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "scans")
data class Scan(
    @PrimaryKey
    val id: Int,
    val lat: Double,
    val lon: Double,
    val name: String?,
    val date: String?,
    val scanPoints: Int,
    val mode: Int,
)
