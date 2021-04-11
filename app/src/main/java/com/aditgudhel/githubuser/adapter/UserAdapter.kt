package com.aditgudhel.githubuser.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.aditgudhel.githubuser.activity.DetailUserActivity
import com.aditgudhel.githubuser.R
import com.aditgudhel.githubuser.data.User
import com.aditgudhel.githubuser.databinding.ItemUserBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class UserAdapter(private val listUser: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)

        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        with(holder) {
            val user = listUser[position]

            Glide.with(holder.itemView.context)
                .load(user.avatar)
                .apply(RequestOptions().override(125,125))
                .into(binding.imgItemAvatar)

            binding.tvItemName.text = user.name
            binding.tvItemUsername.text = String.format("@ %s", user.username)

            binding.cvUser.setOnClickListener {
                val toDetailUserIntent = Intent(it.context, DetailUserActivity::class.java)
                toDetailUserIntent.putExtra(DetailUserActivity.EXTRA_USER, user)
                it.context.startActivity(toDetailUserIntent)
            }
        }
    }

    override fun getItemCount(): Int = listUser.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemUserBinding.bind(itemView)
    }

}