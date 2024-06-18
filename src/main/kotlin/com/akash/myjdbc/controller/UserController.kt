package com.akash.myjdbc.controller

import com.akash.myjdbc.dtos.User
import com.akash.myjdbc.repository.UserRepository
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/users")
class UserController(private val userRepository: UserRepository) {

    @GetMapping("/health")
    fun testAppHealth() {
        println("Yes!")
    }

    /**
     * save a user
     */
    @PostMapping
    fun create(@RequestBody user: User) {
        println("In save All users#")
        userRepository.save(user)
    }

    /**
     * get all users
     *
     */
    @GetMapping
    fun findAll(): List<UserResponse> {
        println("In Get All users#")
        val list = userRepository.findAll()
        val finalResponse: List<UserResponse> = list.map {
            user -> userToUserResponse(user)
        }

        return finalResponse
    }

    fun userToUserResponse(user: User): UserResponse {
        return UserResponse(
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
    fun findById(@PathVariable id: Long): User? {
        return userRepository.findById(id)
    }


    /**
     * update existing user by his id
     */
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody user: User) {
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