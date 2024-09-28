package com.akash.myjdbc.scheduler

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component


@Component
class ScheduledTasks {
    @Scheduled(fixedRate = 5000) // Executes every 5 seconds
    fun reportCurrentTime() {
        println("+5 sec, Current time is: " + System.currentTimeMillis())
    }
}

