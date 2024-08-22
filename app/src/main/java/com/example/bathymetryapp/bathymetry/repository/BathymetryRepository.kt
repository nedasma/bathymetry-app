package com.example.bathymetryapp.bathymetry.repository

import com.example.bathymetryapp.bathymetry.data.model.BathymetryData
import com.example.bathymetryapp.bathymetry.data.model.Scan
import com.example.bathymetryapp.util.ServiceResult

interface BathymetryRepository {
    suspend fun parseScanBathymetryData(
        gridType: String,
        generator: String,
        scanIds: Int,
        token: String
    ): ServiceResult<BathymetryData>

    suspend fun getBathymetryList(token: String): List<Scan>
}