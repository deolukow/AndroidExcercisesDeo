package com.myapp.androidexcercisesdeo.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Content(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
