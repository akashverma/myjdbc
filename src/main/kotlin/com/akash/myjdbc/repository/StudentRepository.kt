package com.akash.myjdbc.repository

import com.akash.myjdbc.dtos.Student
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository

@Repository
class StudentRepository(private val jdbcTemplate: JdbcTemplate) {

    /**
     * """ Triple quotes form a block quote, this helps to maintain the formatting
     * The content in between is the actual query and it does not need any further quote
     */
    private val INSERT_QUERY = """
        insert into student (name, roll) 
        values(?,?)
    """.trimIndent()

    private val FETCH_QUERY = "select * from student"
    private val DELETE_QUERY = "delete from student where id= ? "


    // insert/save query using jdbc template - uses "update()"
    fun insert(student: Student) {
        val row = jdbcTemplate.update(INSERT_QUERY, student.name, student.roll)
        println("Insert Num of rows + $row")
    }

    // fetch query using jdbc template - uses "query()"
    fun getAll(): List<Student> {
        return jdbcTemplate.query(FETCH_QUERY, mapper)
    }

    // delete record by id
    fun deleteById(id: Long) {
        jdbcTemplate.update(DELETE_QUERY, id)
    }

    // mapper is required in fetch method to parse result set returned by the "query(sql, mapper)" method
    val mapper = RowMapper<Student> { rs, rowNum ->
        Student(
            id = rs.getLong("id"),
            name = rs.getString("name"),
            roll = rs.getInt("roll")
        )
    }


}