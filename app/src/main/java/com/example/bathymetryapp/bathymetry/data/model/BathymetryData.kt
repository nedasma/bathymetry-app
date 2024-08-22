package com.example.bathymetryapp.bathymetry.data.model

import kotlinx.serialization.Serializable

/**
 * Data entity storing bathymetry data.
 *
 * @param type a type of bathymetry data, e.g. a FeatureCollection
 * @param bbox rough coordinates of the data, corresponding to 4 extreme points of the scanned place
 * @param features list of geodata
 */
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
