package com.example.poc_test_rx.data

import com.example.poc_test_rx.data.remote.UserService
import com.example.poc_test_rx.domain.User
import com.example.poc_test_rx.presentation.responseGetUserException
import com.example.poc_test_rx.presentation.responseGetUserExpected
import com.example.poc_test_rx.presentation.responseGetUserIOException
import com.example.poc_test_rx.utils.RxAndroidSchedulerRule
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import org.junit.Rule
import java.io.IOException
import kotlin.test.Test

class RepositoryUserTest {

    @get:Rule
    val rxAndroidSchedulerRule = RxAndroidSchedulerRule()

    private val service = mockk<UserService>()
    private val repository = RepositoryUserImp(service)
    private var userExpected: Single<User>? = null

    @Test
    fun `get user service  success`() {
        `given I request user`()
        `when I request user data`()
        `then the user product must be received`()
        `then service get user request once`()
    }

    private fun `given I request user`() {
        coEvery { service.getUser() } returns responseGetUserExpected
    }

    private fun `when I request user data`() {
        userExpected = repository.getUser()
    }

    private fun `then service get user request once`() {
        coVerify(exactly = 1) { service.getUser() }
    }

    private fun `then the user product must be received`() {
        userExpected!!.test().assertComplete()
        userExpected!!.test().assertNoErrors()
        userExpected!!.test().assertValue {
            it.name.isNotEmpty()
            it.description.isNotEmpty()
        }
    }

    @Test
    fun `get user service exception`() {
        `given I request user exception`()
        `when I request user data`()
        `then the exception must be catch`()
        `then service get user request once`()
    }

    private fun `given I request user exception`() {
        coEvery { service.getUser() } returns responseGetUserException
    }

    private fun `then the exception must be catch`() {
        userExpected!!.test().assertError(Exception::class.java)
        userExpected!!.test().assertNotComplete()
    }

    @Test
    fun `get user service io exception`() {
        `given I request user io exception`()
        `when I request user data`()
        `then the io exception must be catch`()
        `then service get user request once`()
    }

    private fun `given I request user io exception`() {
        coEvery { service.getUser() } returns responseGetUserIOException
    }

    private fun `then the io exception must be catch`() {
        userExpected!!.test().assertError(IOException::class.java)
        userExpected!!.test().assertNotComplete()
    }
}