package com.akash.myjdbc.service

import com.akash.myjdbc.dtos.UserDto
import com.akash.myjdbc.repository.UserRepository
import com.akash.myjdbc.service.impl.UserServiceImpl
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class UserServiceTest {

    private val userRepository = mockk<UserRepository>()
    private val userServiceImpl = UserServiceImpl(userRepository)

    @Test
    fun `test create user`() {
        val userDto = UserDto(1, "Kohli", "kohli@oneeight.com")


        // this unit test for service layer only so
        // Mock behaviors for the repository layer - save(), findAll() etc.
        every { userRepository.save(any()) } returns Unit
        every { userRepository.findAll() } returns listOf(userDto)

        userServiceImpl.createNewUser(userDto)

        val res = userServiceImpl.fetchAllUsers()
        assertEquals("Kohli", res[0].name)
    }


    @Test
    fun `test fetch all users when No users registered`() {
        //call the actual service
        every { userRepository.findAll() } returns listOf()
        val response = userServiceImpl.fetchAllUsers()
        // validate/test the actual results against expected
        assertEquals(0, response.size)
    }


    @Test
    fun `test fetchallusers after 3 users registered`() {
        val userDto1 = UserDto(1, "ram", "hsd")
        val userDto2 = UserDto(2, "shyam", "hsd")
        val userDto3 = UserDto(3, "mo", "hsd")

        every { userRepository.save(any()) } returns Unit
        userServiceImpl.createNewUser(userDto1)
        userServiceImpl.createNewUser(userDto2)
        userServiceImpl.createNewUser(userDto3)


        every { userRepository.findAll() } returns listOf(userDto1, userDto2, userDto3)
        val res = userServiceImpl.fetchAllUsers()
        assertEquals(3, res.size)
    }

    @Test
    fun `should return greeting message`() {
        assertEquals("Hello, Kotlin!", "Hello, Kotlin!")
    }

    @Test
    fun `In Kotlin backticks allow you to define method names using spaces, punctuation, or natural language even if they're not valid standard method identifiers`() {
        assertEquals("Hello, Kotlin!", "Hello, Kotlin!")
    }


}