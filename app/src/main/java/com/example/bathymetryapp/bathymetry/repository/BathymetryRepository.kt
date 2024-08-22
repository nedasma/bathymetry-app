package com.example.bathymetryapp.bathymetry.repository

import com.example.bathymetryapp.bathymetry.data.model.BathymetryData
import com.example.bathymetryapp.bathymetry.data.model.Scan
import com.example.bathymetryapp.util.ServiceResult

interface BathymetryRepository {
    /**
     * Parses single scan bathymetric data with a given [gridType], [generator], [scanIds] and a user
     * [token].
     *
     * Returns [BathymetryData] wrapped in a ServiceResult.
     */
    suspend fun parseScanBathymetryData(
        gridType: String = "FAST",
        generator: String = "BS",
        scanIds: Int,
        token: String
    ): ServiceResult<BathymetryData>

    /**
     * Retrieves a list of scans from the local database by a given user [token].
     */
    suspend fun getBathymetryList(token: String): List<Scan>
}