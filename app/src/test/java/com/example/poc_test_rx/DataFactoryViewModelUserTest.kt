package com.example.poc_test_rx

import com.example.poc_test_rx.model.User
import io.reactivex.rxjava3.core.Single

internal val validUser = User(
    1000,
    "Danilo",
    "The best dancer"
)

internal val responseGetUserExpected = Single.just(validUser)

internal val responseGetUserException = Single.error<User>(Exception("Error exception"))