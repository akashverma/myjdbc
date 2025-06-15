package com.akash.myjdbc.controller

import com.akash.myjdbc.scheduler.ScheduledTasks
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/scheduler")
class SchedulerController(private val scheduledTasks: ScheduledTasks) {

    @GetMapping("/start")
    fun startScheduler() {
        scheduledTasks.reportCurrentTime()
    }

}