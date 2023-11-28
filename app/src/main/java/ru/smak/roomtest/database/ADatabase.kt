package ru.smak.roomtest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Student::class], version = 1)
@TypeConverters(LocalDateConverter::class)
abstract class ADatabase : RoomDatabase(){

    abstract fun getStudentDao(): StudentDao
}

object StudentsDatabase{
    private lateinit var db: StudentDao
    fun getDao(applicationContext: Context) = if (!::db.isInitialized){
            db = Room.databaseBuilder(
                applicationContext,
                ADatabase::class.java,
                "students"
            ).build().getStudentDao()
            db
        } else db
}