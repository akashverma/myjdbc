package com.akash.myjdbc.service

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

/**
 * CommandLineRunner interface is a functional interface used to indicate that a bean should run
 * when it is contained within a Spring ApplicationContext.
 * This interface is part of the Spring Boot and Spring Framework's bootstrapping mechanism
 * for executing code at application startup.
 */
@Component
class MyCommandLineRunner: CommandLineRunner {
    override fun run(vararg args: String?) {
        println("This method will be called upon application context startup")
    }
}