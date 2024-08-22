package com.example.bathymetryapp.login.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bathymetryapp.login.data.model.LoginToken

@Dao
interface LoginTokenDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: LoginToken)

    @Query("SELECT * FROM loginToken WHERE token = :token")
    suspend fun select(token: String): LoginToken
}