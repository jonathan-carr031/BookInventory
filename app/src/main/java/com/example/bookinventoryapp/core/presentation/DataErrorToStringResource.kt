package com.example.bookinventoryapp.core.presentation

import com.example.bookinventoryapp.core.domain.DataError

fun DataError.toUiText(): String {
    val stringResource = when (this) {
        DataError.Local.DISK_FULL -> "Something"
        DataError.Local.UNKNOWN -> "Something"
        DataError.Remote.REQUEST_TIMEOUT -> "Something"
        DataError.Remote.TOO_MANY_REQUESTS -> "Something"
        DataError.Remote.NO_INTERNET -> "Something"
        DataError.Remote.SERVER -> "Something"
        DataError.Remote.SERIALIZATION -> "Something"
        DataError.Remote.UNKNOWN -> "Something"
    }

    return stringResource
}