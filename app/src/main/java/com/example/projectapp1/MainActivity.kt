package com.example.projectapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import kotlinx.android.synthetic.main.activity_main.*
import androidx.room.Room
import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext


class MainActivity : AppCompatActivity(), CoroutineScope {

    lateinit var db : AppDatabase
    private lateinit var job : Job
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

 //private lateinit var user : User
   // override val coroutineContext: CoroutineContext
       // get() = Dispatchers.Main + user

    var userList : UserList? = null
    lateinit var editText : EditText
    var currentUser : User? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       job = Job()
        db = AppDatabase.invoke(this)
        var list = listOf<User>()
    CoroutineScope(Dispatchers.IO).async {
        list = db.userDao.getAll()
        var names = ""
        list.forEach {
            Log.d("!!!", it.name!!)
            names += it.name+"\n"
        }
        /* addNewUser(User(0, "Elmir"))
        addNewUser(User(0, "Wedieu"))
        addNewUser(User(0, "Udde"))

        */

        tv_users.text = names
    }
        editText = findViewById(R.id.et_name)

        //loadNewWord()

        loadAllUsers()

        textView.setOnClickListener {

        }




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

    fun loadAllUsers() {
        val words = async(Dispatchers.IO) {
            db.userDao.getAll()
        }

        launch {
            val list = words.await().toMutableList()
            userList = UserList(list)
            loadNewUser()
        }

    }


    fun addNewUser(user :User) {
        userList?.addUser(user)

        launch(Dispatchers.IO) {
            db.userDao.insert(user)
        }
    }

    fun loadNewUser() {
        currentUser =userList?.getNewUser()

        if (currentUser == null)
            return

      //  textView.text = currentUser?.
    }

   // fun revealTranslation() {
    //    textView.text = currentUser?.swedish
   // }

  //  override fun onTouchEvent(event: MotionEvent?): Boolean {
    //    if (event?.action == MotionEvent.ACTION_UP ) {
      //      loadNewUser()
      //  }
       // return true
    }



/*   thread{
            val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "database-name"
            ).build()  // 1

            db.userDao().insertAll(User(1, "Elmir")) // 2
        }



        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "USERNAME")
            .fallbackToDestructiveMigration()
            .build()
*/


