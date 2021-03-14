package com.example.poc_test_rx.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.poc_test_rx.domain.RepositoryUser
import com.example.poc_test_rx.utils.RxAndroidSchedulerRule
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Rule
import org.junit.Test
import java.io.IOException
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class ViewModelUserTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val rxAndroidSchedulerRule = RxAndroidSchedulerRule()
    private val repositoryUser = mockk<RepositoryUser>()
    private val viewModel = ViewModelUser(repositoryUser)

    @Test
    fun `request user data success`() {
        `given I request user success`()
        `when I request user`()
        `then a valid user is returned`()
        `then repository method must be call once`()
    }

    private fun `given I request user success`() {
        every { repositoryUser.getUser() } returns responseGetUserExpected
    }

    private fun `when I request user`() {
        viewModel.getUser()
    }

    private fun `then repository method must be call once`() {
        verify(exactly = 1) { repositoryUser.getUser() }
    }

    private fun `then a valid user is returned`() {
        assertNotNull(viewModel.getUser.value)
        assertEquals(
            viewModel.getUser.value!!,
            validUser
        )
        assertEquals(viewModel.getUser.value!!.id, validUser.id)
    }

    @Test
    fun `request user exception`() {
        `given I request user exception`()
        `when I request user`()
        `then a exception must be catch`()
        `then repository method must be call once`()
    }

    private fun `given I request user exception`() {
        every { repositoryUser.getUser() } returns responseGetUserException
    }

    private fun `then a exception must be catch`() {
        assertNotNull(viewModel.errorGetUser.value)
        assertTrue {
            viewModel.errorGetUser.value is Exception
        }
    }

    @Test
    fun `request user IoException`() {
        `given I request user IoException`()
        `when I request user`()
        `then a IOException must be catch`()
        `then repository method must be call once`()
    }

    private fun `given I request user IoException`() {
        every { repositoryUser.getUser() } returns responseGetUserIOException
    }

    private fun `then a IOException must be catch`() {
        assertNotNull(viewModel.errorGetUser.value)
        assertTrue {
            viewModel.errorGetUser.value is IOException
        }
    }
}
