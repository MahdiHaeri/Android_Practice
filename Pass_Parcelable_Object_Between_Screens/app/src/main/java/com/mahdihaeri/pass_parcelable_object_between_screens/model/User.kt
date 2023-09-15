package com.mahdihaeri.pass_parcelable_object_between_screens.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class User(
    val firstName: String,
    val lastName: String,
): Parcelable