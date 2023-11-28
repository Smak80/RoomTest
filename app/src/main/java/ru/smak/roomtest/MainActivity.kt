package ru.smak.roomtest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.smak.roomtest.database.Student
import ru.smak.roomtest.database.StudentsDatabase
import ru.smak.roomtest.ui.theme.RoomTestTheme
import kotlin.concurrent.thread

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val s1 = Student(
            name = "Иванов И. И.",
            group = "09-060"
        )

//        lifecycleScope.launch {
//            StudentsDatabase.getDao(applicationContext).apply {
//                addStudent(s1)
//                Log.i("STUDENTS", getAllStudents().joinToString())
//            }
//        }

        setContent {
            RoomTestTheme {
                MainUI(
                    modifier = Modifier.fillMaxSize(),
                    content = {
                        //CardList()
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainUI(
    modifier: Modifier = Modifier,
    content: @Composable ()->Unit,
){
    Scaffold(
        modifier = modifier
    ){
        Column(Modifier.padding(it)) {
            content()
        }
    }
}