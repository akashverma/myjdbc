package com.akash.myjdbc.repository


import com.akash.myjdbc.dtos.UserDto
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository

@Repository
class UserRepository(private val jdbcTemplate: JdbcTemplate) {

    fun findAll(): List<UserDto> {
        val sql = "SELECT * FROM users"
        return jdbcTemplate.query(sql, userMapper)
    }

    fun findById(id: Long): UserDto? {
        val sql = "SELECT * FROM users WHERE id = ?"
        return jdbcTemplate.queryForObject(sql, arrayOf<Any>(id), userMapper)
    }


    // All save, update, delete done by - "jdbcTemplate.update()"
    fun save(user: UserDto) {
        val sql = "INSERT INTO users (name, email) VALUES (?, ?)"
        jdbcTemplate.update(sql, user.name, user.email)
    }

    fun update(user: UserDto) {
        val sql = "UPDATE users SET name = ?, email = ? WHERE id = ?"
        jdbcTemplate.update(sql, user.name, user.email, user.id)
    }

    fun delete(id: Long) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id)
    }

    /**
     * creating a lambda and assigning to a variable 'userMapper'
     */
    private val userMapper = RowMapper<UserDto> { rs, _ ->
        UserDto(
            id = rs.getLong("id"),
            name = rs.getString("name"),
            email = rs.getString("email")
        )
    }
}
