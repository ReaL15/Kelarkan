package com.example.todolist.UserPref

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel (
    var name: String? = null,
    var isLogin: Boolean = false
) : Parcelable