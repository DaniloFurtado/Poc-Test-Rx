package com.example.poc_test_rx.domain

import io.reactivex.rxjava3.core.Single

interface RepositoryUser {
    fun getUser(): Single<User>
}