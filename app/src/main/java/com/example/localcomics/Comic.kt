package com.example.localcomics

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Comic(
    var name: String,
    var description: String,
    var photo: Int
) : Parcelable
