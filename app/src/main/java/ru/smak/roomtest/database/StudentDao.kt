package ru.smak.roomtest.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao {

    @Insert(entity = Student::class)
    suspend fun addStudent(student: Student)

    @Update
    fun editStudent(student: Student)

    @Delete
    fun delStudent(student: Student)

    @Query("Select * from student")
    fun getAllStudents(): Flow<List<Student>>

    @Query("Select * from student where id = :id")
    fun getStudentById(id: Int): Student
}