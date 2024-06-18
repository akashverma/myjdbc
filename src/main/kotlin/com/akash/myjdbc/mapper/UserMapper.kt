package com.akash.myjdbc.mapper

import com.akash.myjdbc.controller.UserResponse
import com.akash.myjdbc.dtos.User

class UserMapper {
    public fun userToUserResponse(user: User): UserResponse {
        return UserResponse(
            id = user.id,
            name = user.name,
            email = user.email,
            // Other properties you want to map from User to UserResponse
        )
    }
}