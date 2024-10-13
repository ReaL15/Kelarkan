package com.example.todolist

import android.content.Context
import com.example.todolist.UserActivity
import com.example.todolist.UserPref.UserModel

internal class UserPreference(context: Context) {
    companion object {
        private const val PREFS_NAME = "user_pref"
        private const val NAME = "name"
        private const val ISLOGIN = "islove"
    }

    private val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun setUser(value: UserModel) {
        val editor = preferences.edit()
        editor.putBoolean(ISLOGIN, value.isLogin)
        editor.putString(NAME, value.name)
        editor.apply()
    }

    fun getUser(): UserModel {
        val model = UserModel()
        model.name = preferences.getString(NAME, "")
        model.isLogin = preferences.getBoolean(ISLOGIN, false)
        return model
    }
}