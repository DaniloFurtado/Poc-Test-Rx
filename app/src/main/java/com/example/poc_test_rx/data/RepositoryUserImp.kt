package com.example.poc_test_rx.data

import com.example.poc_test_rx.model.User
import io.reactivex.rxjava3.core.Single

class RepositoryUserImp : RepositoryUser {
    override fun getUser(): Single<User> = Single.just(
        User(
            10,
            "Danilo Test",
            "Simples Cadastros"
        )
    )

}