package com.akash.myjdbc.controller

import com.akash.myjdbc.dtos.UserDto
import com.akash.myjdbc.repository.UserRepository
import com.akash.myjdbc.service.UserService
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.mockito.Mockito.doNothing
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Bean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.mockito.Mockito.*




@WebMvcTest(UserController::class)
class UserControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc


    @MockBean
    private lateinit var userService: UserService


    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Test
    fun `should create a new user`() {
        // Given
        val userDto = UserDto(1, "alice@example.com", "email")

        // No return expected; just verify interaction
        doNothing().`when`(userService).createNewUser(userDto)

        // When + Then
        mockMvc.perform(
            post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDto))
        )
            .andExpect(status().isOk)

        verify(userService, times(1)).createNewUser(userDto)
    }


}