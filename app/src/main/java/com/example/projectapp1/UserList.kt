package com.example.projectapp1

class UserList(private val users : MutableList<User>){

    fun addUser(user: User) {
        users.add(user)
    }


    fun getNewUser() : User? {
        if (users.size <= 0) {
            return null
            // initialize()
        }
        val rnd = (0 until users.size).random()
        val user = users.removeAt(rnd)
        return user
    }

}
