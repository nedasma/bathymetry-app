package com.example.bathymetryapp.bathymetry.usecase

import com.example.bathymetryapp.bathymetry.repository.BathymetryRepository
import javax.inject.Inject

class GetScanBathymetryDataUseCase @Inject constructor(
    private val repository: BathymetryRepository
) {

    suspend operator fun invoke() {
        // TODO: invoke repository to parse single scan data and wrap it into displayable map data
    }
}