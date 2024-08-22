package com.example.bathymetryapp.bathymetry.repository

import com.example.bathymetryapp.bathymetry.data.model.BathymetryData
import com.example.bathymetryapp.bathymetry.data.model.BathymetryDataDto
import com.example.bathymetryapp.bathymetry.data.model.Scan
import com.example.bathymetryapp.login.data.db.ApplicationDatabase
import com.example.bathymetryapp.util.API_BASE_URL
import com.example.bathymetryapp.util.ServiceResult
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType

class BathymetryRepositoryImpl(
    private val client: HttpClient,
    private val db: ApplicationDatabase
) : BathymetryRepository {
    override suspend fun parseScanBathymetryData(
        gridType: String,
        generator: String,
        scanIds: Int,
        token: String
    ): ServiceResult<BathymetryData> {
        return try {
            val response = client.get("$API_BASE_URL/geoData") {
                header(HttpHeaders.Accept, "*/*")
                contentType(ContentType.Application.Json)
                url {
                    parameters.append("grid", gridType)
                    parameters.append("generator", generator)
                    parameters.append("scanIds", scanIds.toString())
                    parameters.append("token", token)
                }
            }.body<BathymetryDataDto>()
            ServiceResult.Success(response.bathymetry)
        } catch (exception: Exception) {
            ServiceResult.Error("Could not get bathymetry data: $exception")
        }
    }

    override suspend fun getBathymetryList(token: String): List<Scan> = db.getScanDao().selectAll()
}