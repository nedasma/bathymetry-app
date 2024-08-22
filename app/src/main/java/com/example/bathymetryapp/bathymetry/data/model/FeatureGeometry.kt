package com.example.bathymetryapp.bathymetry.data.model

import kotlinx.serialization.Serializable

@Serializable
data class FeatureGeometry(
    val type: String,
    val bbox: List<Double>,
    val coordinates: List<List<List<Double>>>
)