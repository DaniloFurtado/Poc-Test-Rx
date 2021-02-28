package com.example.poc_test_rx.data.remote

import com.example.poc_test_rx.domain.User
import io.reactivex.rxjava3.core.Single

interface UserService {
    fun getUser(): Single<User>
}