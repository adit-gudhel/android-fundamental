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
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class UserAdapter(private val listUser: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)

        return ListViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = listUser[position]

        Glide.with(holder.itemView.context)
                .load(user.avatar)
                .apply(RequestOptions().override(125,125))
                .into(holder.imgAvatar)

        holder.tvName.text = user.name
        holder.tvUsername.text = "@" + user.username

        holder.cvUser.setOnClickListener {
            val toDetailUserIntent = Intent(it.context, DetailUserActivity::class.java)
            toDetailUserIntent.putExtra(DetailUserActivity.EXTRA_USER, user)
            it.context.startActivity(toDetailUserIntent)
        }
    }

    override fun getItemCount(): Int = listUser.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvUsername: TextView = itemView.findViewById(R.id.tv_item_username)
        var imgAvatar: ImageView = itemView.findViewById(R.id.img_item_avatar)
        var cvUser: CardView = itemView.findViewById(R.id.cv_user)
    }

}