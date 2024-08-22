package com.example.bathymetryapp.bathymetry.di

import com.example.bathymetryapp.bathymetry.repository.BathymetryRepository
import com.example.bathymetryapp.bathymetry.repository.BathymetryRepositoryImpl
import com.example.bathymetryapp.login.data.db.ApplicationDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

/**
 * DI module, containing all the necessary modules provided for the bathymetry feature package.
 * @see com.example.bathymetryapp.login.di.LoginModule for a similar implementation.
 */
@Module
@InstallIn(SingletonComponent::class)
object BathymetryModule {

    @Provides
    @Singleton
    fun provideBathymetryRepository(
        client: HttpClient,
        db: ApplicationDatabase
    ): BathymetryRepository = BathymetryRepositoryImpl(client, db)
}