package com.example.projectapp1

import android.content.ClipData
import androidx.room.Database
import androidx.room.RoomDatabase
import se.iths.au20.au20roomintro.User

import se.iths.au20.au20roomintro.UserDao

@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}