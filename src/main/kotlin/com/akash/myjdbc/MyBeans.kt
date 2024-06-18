package com.akash.myjdbc

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * class to demonstrate how even methods can be treated as 'beans'
 * and they can be handled/accessed via spring context (check MyJdbcApplication.kt)
 */
@Configuration
class MyBeans() {

    @Bean
    fun name(): String {
        return "Akash"
    }

    @Bean
    fun age(): Int {
        return 15;
    }

    @Bean(name = ["customBean"])
    fun customBean(): String{
        return "I am a custom bean"
    }
}