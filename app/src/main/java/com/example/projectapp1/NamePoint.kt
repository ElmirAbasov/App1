package com.example.projectapp1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "User")
data class User(@PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "USERNAME") val name: String?)
    // to save points
 //   @ColumnInfo(point = "POINTS" ) val point: Int?)