package com.aditgudhel.githubuser.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.aditgudhel.githubuser.R
import com.aditgudhel.githubuser.data.User
import com.aditgudhel.githubuser.databinding.ActivityDetailUserBinding

class DetailUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val user = intent.getParcelableExtra<User>(EXTRA_USER)

        val actionbar = supportActionBar
        actionbar?.title = user?.name
        actionbar?.setDisplayHomeAsUpEnabled(true)

        user?.avatar?.let { binding.ivAvatar.setImageResource(it) }
        binding.tvName.text = user?.name
        binding.tvUsername.text = String.format("@ %s", user?.username)
        binding.tvCompany.text = user?.company
        binding.tvLocation.text = user?.location
        binding.tvRepository.text = user?.repository.toString()
        binding.tvFollower.text = user?.follower.toString()
        binding.tvFollowing.text = user?.following.toString()

        binding.btnShare.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_SUBJECT, "Github User's")
                putExtra(Intent.EXTRA_TEXT, "https://github.com/${user?.username}")
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)

            startActivity(Intent.createChooser(shareIntent, "Pilih salah satu"))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()

        return true
    }

}