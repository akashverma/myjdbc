package com.akash.myjdbc.service.impl

import com.akash.myjdbc.dtos.UserDto
import com.akash.myjdbc.repository.UserRepository
import com.akash.myjdbc.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userRepository: UserRepository): UserService{
    override fun createNewUser(user:UserDto) {
        userRepository.save(user)
    }

    override fun fetchAllUsers(): List<UserDto> {
        return userRepository.findAll()
    }

    override fun fetchUserById(id : Long): UserDto {
        return userRepository.findById(id)?:throw Exception("User not found")
    }

    override fun updateUserById(user: UserDto) {
        userRepository.update(user)
    }

    override fun deleteUserById(userId:Long) {
        userRepository.delete(userId)
    }
}