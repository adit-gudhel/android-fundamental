package com.aditgudhel.githubuser

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.aditgudhel.githubuser.data.User
import de.hdodenhof.circleimageview.CircleImageView

class DetailUserActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val civAvatar:CircleImageView = findViewById(R.id.civ_avatar)
        val tvName: TextView = findViewById(R.id.tv_name)
        val tvUsername: TextView = findViewById(R.id.tv_username)
        val tvCompany: TextView = findViewById(R.id.tv_company)
        val tvLocation: TextView = findViewById(R.id.tv_location)
        val tvRepository: TextView = findViewById(R.id.tv_repository)
        val tvFollower: TextView = findViewById(R.id.tv_follower)
        val tvFollowing: TextView = findViewById(R.id.tv_following)
        val btnShare: Button = findViewById(R.id.btn_share)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        val actionbar = supportActionBar
        actionbar!!.title = user.name
        actionbar.setDisplayHomeAsUpEnabled(true)

        civAvatar.setImageResource(user.avatar)
        tvName.text = user.name
        tvUsername.text = "@" + user.username
        tvCompany.text = user.company + " | "
        tvLocation.text = user.location
        tvRepository.text = user.repository.toString()
        tvFollower.text = user.follower.toString()
        tvFollowing.text = user.following.toString()

        btnShare.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_SUBJECT, "Github User's")
                putExtra(Intent.EXTRA_TEXT, "https://github.com/" + user.username)
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