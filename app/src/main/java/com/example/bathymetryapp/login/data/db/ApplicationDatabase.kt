package com.example.bathymetryapp.login.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bathymetryapp.bathymetry.data.dao.ScanDao
import com.example.bathymetryapp.bathymetry.data.model.Scan
import com.example.bathymetryapp.login.data.dao.LoginTokenDao
import com.example.bathymetryapp.login.data.model.LoginToken

@Database(entities = [LoginToken::class, Scan::class], version = 1, exportSchema = false)
abstract class ApplicationDatabase : RoomDatabase() {

    abstract fun getLoginTokenDao(): LoginTokenDao
    abstract fun getScanDao(): ScanDao

    companion object {
        @Volatile
        private var instance: ApplicationDatabase? = null
        private val lock = Any()

        /**
         * Creates a new database instance with the given [context] or returns the existing [ApplicationDatabase]
         * instance.
         */
        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ApplicationDatabase::class.java,
                "database.db"
            ).build()
    }
}