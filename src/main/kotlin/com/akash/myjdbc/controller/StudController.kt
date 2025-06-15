package com.akash.myjdbc.controller

import com.akash.myjdbc.dtos.Student
import com.akash.myjdbc.repository.StudentRepository
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/stud")
class StudController(private val studRepository: StudentRepository) {

    @GetMapping("/health")
    fun testAppHealth() {
        println("Yes!")
    }

    /**
     * save a user
     */
    @PostMapping
    fun create(@RequestBody stud: Student) {
        println("In save All users#")
        studRepository.insert(stud)
    }

    /**
     * get all users
     */
    @GetMapping
    fun getAllUsers(): List<Student> {
        println("In get all users")
        return studRepository.getAll()
    }

    /**
     * delete user by id
     */
    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) {
        println("In delete by id")
        return studRepository.deleteById(id)
    }


    /**
     * get user by id
     */
    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id:Long): Student?{
        return studRepository.getById(id)
    }


    /**
     * update existing user by his id
     */



}