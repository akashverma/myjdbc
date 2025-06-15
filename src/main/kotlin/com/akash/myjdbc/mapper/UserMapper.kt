package com.akash.myjdbc.mapper

import com.akash.myjdbc.controller.UserResponseDto
import com.akash.myjdbc.dtos.UserDto

class UserMapper {
    public fun userToUserResponse(user: UserDto): UserResponseDto {
        return UserResponseDto(
            id = user.id,
            name = user.name,
            email = user.email,
            // Other properties you want to map from User to UserResponse
        )
    }
}