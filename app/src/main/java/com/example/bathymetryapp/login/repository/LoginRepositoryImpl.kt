package com.example.bathymetryapp.login.repository

import com.example.bathymetryapp.login.data.db.ApplicationDatabase
import com.example.bathymetryapp.login.data.model.LoginDetails
import com.example.bathymetryapp.login.data.model.LoginResponse
import com.example.bathymetryapp.util.API_BASE_URL
import com.example.bathymetryapp.util.ServiceResult
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType

class LoginRepositoryImpl(
    private val client: HttpClient,
    private val db: ApplicationDatabase
) : LoginRepository {
    override suspend fun postLoginDetails(loginDetails: LoginDetails): ServiceResult<String> {
        return try {
            val response = client.post("$API_BASE_URL/login") {
                header(HttpHeaders.Accept, "*/*")
                contentType(ContentType.Application.Json)
                setBody(loginDetails)
            }.body<LoginResponse>()

            db.getLoginTokenDao().upsert(response.login)
            db.getScanDao().upsertAll(response.scans)

            ServiceResult.Success(response.login.token)
        } catch (exception: Exception) {
            ServiceResult.Error("Could not post login details: $exception")
        }
    }
}