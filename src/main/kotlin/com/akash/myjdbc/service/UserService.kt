package com.akash.myjdbc.service

import com.akash.myjdbc.dtos.UserDto

interface UserService {
    fun createNewUser(user:UserDto)

    fun fetchAllUsers(): List<UserDto>

    fun fetchUserById()

    fun updateUserById()

    fun deleteUserById()
}