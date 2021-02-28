package com.example.poc_test_rx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.poc_test_rx.data.RepositoryUser
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}