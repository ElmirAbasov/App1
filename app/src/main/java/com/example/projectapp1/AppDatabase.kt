package com.example.projectapp1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 4)
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao : UserDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null
     private val LOCK = Any()
        operator fun invoke(context: Context) = INSTANCE?: synchronized(LOCK)
        {
        INSTANCE?: createDatabase(context).also{
            INSTANCE = it
        }

        }
    private fun createDatabase(context: Context) = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java,"usernamedao").build()
    }
}
