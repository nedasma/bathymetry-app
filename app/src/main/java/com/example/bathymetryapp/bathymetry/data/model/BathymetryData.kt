package com.example.bathymetryapp.bathymetry.data.model

import kotlinx.serialization.Serializable

@Serializable
data class BathymetryData(
    val type: String,
    val bbox: List<Double>,
    val features: List<Feature>
)

@Serializable
data class BathymetryDataDto(
    val bathymetry: BathymetryData
)
