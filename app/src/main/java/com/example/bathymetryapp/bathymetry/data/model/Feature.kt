package com.example.bathymetryapp.bathymetry.data.model

import kotlinx.serialization.Serializable

/**
 * Data entity storing bathymetry data. A feature consists of:
 *
 * @param type a type of feature, but usually it's self-evident, e.g. a Feature
 * @param properties contains the ID of the feature and the depth parameter
 * @param geometry geodata polygons with coordinates, used to draw depth maps
 */
@Serializable
data class Feature(
    val type: String,
    val properties: FeatureProperties,
    val geometry: FeatureGeometry
)


