package com.example.bathymetryapp.bathymetry.usecase

import com.example.bathymetryapp.bathymetry.data.model.Scan
import com.example.bathymetryapp.bathymetry.repository.BathymetryRepository
import javax.inject.Inject

class GetScansListUseCase @Inject constructor(
    private val repository: BathymetryRepository
) {
    suspend operator fun invoke(token: String): List<Scan> = repository.getBathymetryList(token)
}