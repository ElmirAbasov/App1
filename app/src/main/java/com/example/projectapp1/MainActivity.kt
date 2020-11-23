package com.example.projectapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.coroutines.CoroutineContext
import androidx.room.Room
import kotlinx.coroutines.*
import se.iths.au20.au20roomintro.User
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {


    private lateinit var job: Job
    val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job
    private lateinit var db : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       job = Job()

        thread{
            val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "database-name"
            ).build()  // 1

            db.userDao().insertAll(User(1, "Elmir", "Abasov")) // 2
        }



        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "name-point")
            .fallbackToDestructiveMigration()
            .build()


        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN


        btn_start.setOnClickListener() {

            if (et_name.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, QuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, et_name.text.toString())
                startActivity(intent)
                finish()
            }

        }

    }

}



