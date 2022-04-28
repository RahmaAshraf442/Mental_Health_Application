package com.example.mental_health_app.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mental_health_app.database.dao.ChatDao
import com.example.mental_health_app.database.entities.MessageEntity

@Database(entities = [MessageEntity::class], version = 1, exportSchema = false)
abstract class PtDatabase : RoomDatabase(){

    abstract fun messagesDao(): ChatDao
}