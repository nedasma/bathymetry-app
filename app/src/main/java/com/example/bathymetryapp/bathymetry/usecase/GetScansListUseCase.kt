package com.example.bathymetryapp.bathymetry.usecase

import com.example.bathymetryapp.bathymetry.data.model.Scan
import com.example.bathymetryapp.bathymetry.repository.BathymetryRepository
import javax.inject.Inject

/**
 * Invokes the bathymetry [repository] by getting a list of bathymetric items (scans) by a given
 * token. Returns a list of mentioned scans.
 */
class GetScansListUseCase @Inject constructor(
    private val repository: BathymetryRepository
) {
    suspend operator fun invoke(token: String): List<Scan> = repository.getBathymetryList(token)
}