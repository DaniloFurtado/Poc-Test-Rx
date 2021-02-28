package com.example.poc_test_rx.data

import com.example.poc_test_rx.model.User
import io.reactivex.rxjava3.core.Single

interface RepositoryUser {
    fun getUser(): Single<User>
}