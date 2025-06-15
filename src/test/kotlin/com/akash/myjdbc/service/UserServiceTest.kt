package com.akash.myjdbc.service

import com.akash.myjdbc.dtos.UserDto
import com.akash.myjdbc.repository.UserRepository
import com.akash.myjdbc.service.impl.UserServiceImpl
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UserServiceTest {

    private val userRepository = mockk<UserRepository>()
    private val userService = UserServiceImpl(userRepository)

    @Test
    fun `test create user`(){
        val userDto = UserDto(1, "Kohli", "kohli@oneeight.com")


        // this unit test for service layer only so
        // Mock behaviors for the repository layer - save(), findAll() etc.
        every { userRepository.save(any()) } returns Unit
        every { userRepository.findAll() } returns listOf(userDto)

        userService.createNewUser(userDto)

        val res = userService.fetchAllUsers()
        assertEquals("Kohli", res[0].name)
    }

    @Test
    fun `should return greeting message`() {
        assertEquals("Hello, Kotlin!", "Hello, Kotlin!")
    }

    @Test
    fun `In Kotlin backticks allow you to define method names using spaces, punctuation, or natural language even if they're not valid standard method identifiers`(){
        assertEquals("Hello, Kotlin!", "Hello, Kotlin!")
    }





}