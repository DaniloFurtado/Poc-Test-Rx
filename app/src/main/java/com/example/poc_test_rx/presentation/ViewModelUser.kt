package com.example.poc_test_rx.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.poc_test_rx.util.BaseViewModel
import com.example.poc_test_rx.data.RepositoryUser
import com.example.poc_test_rx.domain.User
import com.example.poc_test_rx.util.androidSubscribe
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class ViewModelUser(
    private val repositoryUser: RepositoryUser
) : BaseViewModel() {

    private val _getUser = MutableLiveData<User>()
    val getUser: LiveData<User> = _getUser
    private val _errorGetUser = MutableLiveData<Throwable>()
    val errorGetUser: LiveData<Throwable> = _errorGetUser

    fun getUser() {
        repositoryUser
            .getUser()
            .androidSubscribe()
            .subscribe(
                _getUser::setValue,
                _errorGetUser::setValue
            ).addToDisposable()
    }
}