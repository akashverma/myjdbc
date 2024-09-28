package com.akash.myjdbc.controller

import com.akash.myjdbc.dtos.User
import com.akash.myjdbc.dtos.Student
import com.akash.myjdbc.repository.StudentRepository
import com.akash.myjdbc.scheduler.ScheduledTasks
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/scheduler")
class SchedulerController(private val scheduledTasks: ScheduledTasks) {

    @GetMapping("/start")
    fun startScheduler() {
        scheduledTasks.reportCurrentTime()
    }

}