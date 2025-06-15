package com.akash.myjdbc.controller

import com.akash.myjdbc.dtos.UserDto
import com.akash.myjdbc.repository.UserRepository
import com.akash.myjdbc.service.UserService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/users")
class UserController(private val userRepository: UserRepository,
    private val userService: UserService) {

    @GetMapping("/health")
    fun testAppHealth() {
        println("Yes!")
    }

    /**
     * save a user
     */
    @PostMapping
    fun create(@RequestBody user: UserDto) {
        println("In save All users#")
        userService.createNewUser(user)
    }

    /**
     * get all users
     *
     */
    @GetMapping
    fun findAll(): List<UserResponseDto> {
        println("In Get All users#")
        val list = userService.fetchAllUsers()
        val finalResponse: List<UserResponseDto> = list.map {
            user -> userToUserResponse(user)
        }

        return finalResponse
    }

    fun userToUserResponse(user: UserDto): UserResponseDto {
        return UserResponseDto(
            id = user.id,
            name = user.name,
            email = user.email,
            // Other properties you want to map from User to UserResponse
        )
    }





    /**
     * get user by id
     */
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): UserDto? {
        return userRepository.findById(id)
    }


    /**
     * update existing user by his id
     */
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody user: UserDto) {
        user.id = id
        userRepository.update(user)
    }

    /**
     * delete user by id
     */
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        userRepository.delete(id)
    }
}