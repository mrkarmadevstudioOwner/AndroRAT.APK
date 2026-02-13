package com.lunex.core.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    
    // Abstract DAO methods will be added here as needed
    // abstract fun userDao(): UserDao
    
    companion object {
        const val DATABASE_NAME = "lunex_database"
    }
}
