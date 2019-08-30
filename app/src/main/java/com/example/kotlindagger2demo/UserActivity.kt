package com.example.kotlindagger2demo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindagger2demo.dagger2.DaggerUserComponent
import com.example.kotlindagger2demo.mvp.bean.User
import javax.inject.Inject

/**
 * 手动注入
 */
class UserActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        fun newIntent(activity: Activity): Intent {
            return Intent(activity, UserActivity::class.java)
        }
    }

    @Inject
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        //等价于继承 DaggerAppCompatActivity
        DaggerUserComponent.builder().build().injectUserActivity(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_scrolling)
        Log.e("UserActivity", "user $user")
    }
}