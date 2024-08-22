package com.example.bathymetryapp.bathymetry.data.model

import kotlinx.serialization.Serializable

@Serializable
data class FeatureProperties(
    val depth: Double,
    val id: String
)
