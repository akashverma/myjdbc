package com.akash.myjdbc

import org.springframework.beans.factory.getBean
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.AnnotationConfigApplicationContext

@SpringBootApplication
class MyjdbcApplication

fun main(args: Array<String>) {
    runApplication<MyjdbcApplication>(*args)

    // code to demonstrate creation of 'Custom' spring beans see "MyBeans.kt"
    val context = AnnotationConfigApplicationContext(MyBeans::class.java)
    val name = context.getBean("name")
    val customBean = context.getBean("customBean")
    val age = context.getBean("age")
    println(name)
    println(customBean)
    println(age)
}
