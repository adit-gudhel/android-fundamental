package com.aditgudhel.githubuser.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aditgudhel.githubuser.R
import com.aditgudhel.githubuser.adapter.UserAdapter
import com.aditgudhel.githubuser.data.User
import com.aditgudhel.githubuser.data.UserData

class MainActivity : AppCompatActivity() {

    private lateinit var rvUsers: RecyclerView
    private var list: ArrayList<User> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUsers = findViewById(R.id.rv_users)
        rvUsers.setHasFixedSize(true)

        list.addAll(UserData.listData)

        showRecyclerList()
    }

    @Override
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)

        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_about -> {
                val toAboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(toAboutIntent)
            }
        }
    }

    private fun showRecyclerList() {
        rvUsers.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = UserAdapter(list)
        rvUsers.adapter = listUserAdapter
    }

}