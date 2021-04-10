package com.aditgudhel.githubuser.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.aditgudhel.githubuser.data.User
import com.aditgudhel.githubuser.R
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter internal constructor(private val context:Context) : BaseAdapter() {

    internal var users = arrayListOf<User>()

    override fun getCount(): Int = users.size

    override fun getItem(position: Int): Any = users[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if(itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)
        val user = getItem(position) as User
        viewHolder.bind(user)

        return itemView
    }

    private inner class ViewHolder(view: View) {
        private val tvName: TextView = view.findViewById(R.id.tv_name)
        private val tvUsername: TextView = view.findViewById(R.id.tv_username)
        private val civAvatar: CircleImageView = view.findViewById(R.id.civ_avatar)
        private val tvCompany: TextView? = view.findViewById(R.id.tv_company)
        private val tvLocation: TextView? = view.findViewById(R.id.tv_location)
        private val tvRepository: TextView? = view.findViewById(R.id.tv_repository)
        private val tvFollower: TextView = view.findViewById(R.id.tv_follower)
        private val tvFollowing: TextView = view.findViewById(R.id.tv_following)

        @SuppressLint("SetTextI18n")
        fun bind(user: User) {
            tvName.text = user.name
            tvUsername.text = "@" + user.username
            civAvatar.setImageResource(user.avatar)
            tvCompany?.text = user.company
            tvLocation?.text = user.location
            tvRepository?.text = user.repository.toString()
            tvFollower.text = user.follower.toString()
            tvFollowing.text = user.following.toString()
        }
    }
}