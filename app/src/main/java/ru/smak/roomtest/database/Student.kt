package ru.smak.roomtest.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "student")
data class Student(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    var name: String,

    @ColumnInfo(name = "birthday")
    var birth: LocalDate = LocalDate.now().minusYears(18),

    @ColumnInfo(name = "academ_group")
    var group: String,
)