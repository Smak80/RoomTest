package ru.smak.roomtest

import android.app.Application
import android.content.Context
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.smak.roomtest.database.Student
import ru.smak.roomtest.database.StudentsDatabase

class ListViewModel(app: Application) : AndroidViewModel(app) {

    private val db = StudentsDatabase.getDao(
        getApplication<Application>().applicationContext
    )

    val students: Flow<List<Student>>
        get() = db.getAllStudents()

}