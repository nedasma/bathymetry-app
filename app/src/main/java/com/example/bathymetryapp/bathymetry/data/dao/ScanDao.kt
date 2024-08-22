package com.example.bathymetryapp.bathymetry.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bathymetryapp.bathymetry.data.model.Scan

@Dao
interface ScanDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(items: List<Scan>)

    @Query("SELECT * FROM scans")
    suspend fun selectAll(): List<Scan>
}