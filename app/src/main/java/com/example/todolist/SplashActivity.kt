package com.example.todolist

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.todolist.UserPref.UserModel
import com.example.todolist.presentation.MainActivity


class SplashActivity : AppCompatActivity() {

    private lateinit var  mUserPreference: UserPreference
    private lateinit var  userModel: UserModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.main_color)
        }

        mUserPreference = UserPreference(this)
        userModel = mUserPreference.getUser()

        Handler(Looper.getMainLooper()).postDelayed({
            //cek apakah user itu sudah pernah masuk aplikasi atau belum
            if (!userModel.isLogin) {
                //kalau user belum pernah login akan memainkan splash screen
                startActivity(Intent(this@SplashActivity, OnboardingActivity::class.java))
                finish()
            } else {
                //pindah ke Main Activity langsung ketika sudah login
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            }
        }, 3000)
    }
}