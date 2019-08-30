package com.example.kotlindagger2demo

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import android.view.Menu
import android.view.MenuItem
import com.example.kotlindagger2demo.mvp.bean.User
import com.example.kotlindagger2demo.mvp.reg.RegContract
import com.example.kotlindagger2demo.mvp.reg.RegPresenter
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_scrolling.*
import javax.inject.Inject

class ScrollingActivity : DaggerAppCompatActivity(), RegContract.View {

    @Inject
    lateinit var user: User
    @Inject
    lateinit var presenter: RegPresenter
    @Inject
    lateinit var mContentFragment: ContentFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        supportFragmentManager.beginTransaction().add(R.id.fl_view, mContentFragment)
            .commitAllowingStateLoss()

        presenter.bindView(this)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        Log.e("onCreate", "user $user  p is ${presenter.hashCode()}")

        presenter.findUserList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun completed(userList: List<User>) {
        Log.e("completed", "userList $userList")
    }
}
