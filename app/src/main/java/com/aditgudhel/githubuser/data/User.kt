package com.aditgudhel.githubuser.data

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var username: String? = "",
    var name: String? = "",
    var avatar: Int? = 0,
    var company: String? = "",
    var location: String? = "",
    var repository: Int? = 0,
    var follower: Int? = 0,
    var following: Int? = 0
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int
    )
    companion object : Parceler<User> {

        override fun User.write(parcel: Parcel, flags: Int) {
            parcel.writeString(username)
            parcel.writeString(name)
            parcel.writeValue(avatar)
            parcel.writeString(company)
            parcel.writeString(location)
            parcel.writeValue(repository)
            parcel.writeValue(follower)
            parcel.writeValue(following)
        }

        override fun create(parcel: Parcel): User {
            return User(parcel)
        }
    }
}