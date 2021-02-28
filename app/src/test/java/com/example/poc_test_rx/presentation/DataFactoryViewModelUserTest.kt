package com.example.poc_test_rx.presentation

import com.example.poc_test_rx.domain.User
import io.reactivex.rxjava3.core.Single
import java.io.IOException

internal val validUser = User(
    1000,
    "Danilo",
    "The best dancer"
)

internal val responseGetUserExpected = Single.just(validUser)

internal val responseGetUserException = Single.error<User>(Exception("Error exception"))

internal val responseGetUserIOException = Single.error<User>(IOException("Error connection"))