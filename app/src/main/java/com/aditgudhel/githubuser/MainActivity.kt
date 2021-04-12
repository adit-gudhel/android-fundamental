package com.aditgudhel.githubuser

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import com.aditgudhel.githubuser.adapter.UserAdapter
import com.aditgudhel.githubuser.data.User
import com.aditgudhel.githubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataAvatar: TypedArray
    private lateinit var dataCompany: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: IntArray
    private lateinit var dataFollower: IntArray
    private lateinit var dataFollowing: IntArray
    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val listView:ListView = binding.lvList
        adapter = UserAdapter(this)
        listView.adapter = adapter

        prepare()

        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val user: User = users[position]
            val toDetailUserIntent = Intent(this@MainActivity, DetailUserActivity::class.java)
            toDetailUserIntent.putExtra(DetailUserActivity.EXTRA_USER, user)
            startActivity(toDetailUserIntent)
        }
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataUsername = resources.getStringArray(R.array.data_username)
        dataAvatar = resources.obtainTypedArray(R.array.data_avatar)
        dataCompany = resources.getStringArray(R.array.data_company)
        dataLocation = resources.getStringArray(R.array.data_location)
        dataRepository = resources.getIntArray(R.array.data_repository)
        dataFollower = resources.getIntArray(R.array.data_follower)
        dataFollowing = resources.getIntArray(R.array.data_following)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val user = User(
                dataUsername[position],
                dataName[position],
                dataAvatar.getResourceId(position, -1),
                dataCompany[position],
                dataLocation[position],
                dataRepository[position],
                dataFollower[position],
                dataFollowing[position]
            )
            users.add(user)
        }
        adapter.users = users
    }

}