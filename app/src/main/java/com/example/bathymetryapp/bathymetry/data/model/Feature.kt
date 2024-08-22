package com.example.bathymetryapp.bathymetry.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Feature(
    val type: String,
    val properties: FeatureProperties,
    val geometry: FeatureGeometry
)


