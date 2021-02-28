package com.example.poc_test_rx.data

import com.example.poc_test_rx.data.remote.UserService
import com.example.poc_test_rx.domain.RepositoryUser
import com.example.poc_test_rx.domain.User
import io.reactivex.rxjava3.core.Single

class RepositoryUserImp(
    private val userService: UserService
) : RepositoryUser {
    override fun getUser(): Single<User> = userService.getUser()

}