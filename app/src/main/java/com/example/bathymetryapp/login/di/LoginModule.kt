package com.example.bathymetryapp.login.di

import android.content.Context
import com.example.bathymetryapp.login.data.db.ApplicationDatabase
import com.example.bathymetryapp.login.repository.LoginRepository
import com.example.bathymetryapp.login.repository.LoginRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

/**
 * DI module, containing all the necessary modules provided for the login feature package. Note that
 * HttpClient and database singletons are used in bathymetry package as well, so it could be a subject
 * of moving to a different, top-level DI module.
 */
@Module
@InstallIn(SingletonComponent::class)
object LoginModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient(Android) {
            install(Logging)
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    ignoreUnknownKeys = true
                    encodeDefaults = true
                })
            }
        }
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): ApplicationDatabase = ApplicationDatabase.invoke(context)

    @Provides
    @Singleton
    fun provideLoginRepository(
        client: HttpClient,
        db: ApplicationDatabase
    ): LoginRepository = LoginRepositoryImpl(client, db)
}