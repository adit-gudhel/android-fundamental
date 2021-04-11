package com.aditgudhel.githubuser.data

import com.aditgudhel.githubuser.R

object UserData {

    private val name = arrayOf(
        "Aditya Nursyahbani",
        "Jake Wharton",
        "Amit Shekar",
        "Romain Guy",
        "Christ Banes",
        "David",
        "Ravi Tamada",
        "Budi Oktaviyan",
        "Hendi Santika",
        "Sidiq Permana")

    private val username = arrayOf(
        "adit-gudhel",
        "JakeWharton",
        "amitshekhariitbhu",
        "romainguy",
        "chrisbanes",
        "tipsy",
        "ravi8x",
        "budioktaviyan",
        "hendisantika",
        "sidiqpermana"
    )

    private val company = arrayOf(
        "BPPT",
        "Google, Inc.",
        "@MindOrksOpenSource",
        "Google",
        "@google working on @android",
        "Working Group Two",
        "AndroidHive | Droid5",
        "@KotlinID",
        "@JVMDeveloperID @KotlinID @IDDevOps",
        "Nusantara Beta Studio"
    )

    private val avatar = intArrayOf(
        R.drawable.user1,
        R.drawable.user2,
        R.drawable.user3,
        R.drawable.user4,
        R.drawable.user5,
        R.drawable.user6,
        R.drawable.user7,
        R.drawable.user8,
        R.drawable.user9,
        R.drawable.user10)

    private val location = arrayOf(
        "Jakarta, ID",
        "Pittsburgh, PA, USA",
        "New Delhi, India",
        "California",
        "Sydney, Australia",
        "Trondheim, Norway",
        "India",
        "Jakarta, Indonesia",
        "Bojongsoang - Bandung Jawa Barat",
        "Jakarta Indonesia"
    )

    private val repository = intArrayOf(24, 102, 37, 9, 30, 56, 28, 110, 1064, 65)

    private val follower = intArrayOf(4, 56995, 5153, 7972, 14725, 788, 18628, 178, 428, 465)

    private val following = intArrayOf(1, 12, 2, 0, 1, 0, 3, 23, 61, 10)

    val listData: ArrayList<User>
        get() {
            val list = arrayListOf<User>()
            for (position in name.indices) {
                val user = User()
                user.username = username[position]
                user.name = name[position]
                user.avatar = avatar[position]
                user.company = company[position]
                user.location = location[position]
                user.repository = repository[position]
                user.follower = follower[position]
                user.following = following[position]
                list.add(user)
            }

            return list
        }
}