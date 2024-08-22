package com.example.bathymetryapp.bathymetry.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

/**
 * Data entity storing a single scan.
 *
 * @param id unique scan ID
 * @param lat scan's latitude
 * @param lon scan's longitude
 * @param name scan location name (can be null)
 * @param date date when the scan was performed (can be null)
 * @param scanPoints how many scan points this whole scan contains
 * @param mode N/A
 */
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
