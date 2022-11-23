package com.study.kotlininactionpractice.kotlin_deep_dive.day1

import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.util.*
import kotlin.concurrent.schedule
import kotlin.concurrent.scheduleAtFixedRate

class TimerTest {

    @Test
    fun test1() {
        println("schedule a job: " + LocalDateTime.now())

        Timer().schedule(2000) {
            println("running a job: " + LocalDateTime.now())
        }

        println("done: " + LocalDateTime.now())
    }

    @Test
    fun test2() {
        println("schedule a job: " + LocalDateTime.now())

        Timer().schedule(object : TimerTask() {
            override fun run() {
                println("running a job: " + LocalDateTime.now())
            }
        }, 1000)

        println("done: " + LocalDateTime.now())
    }

    @Test
    fun test3() {
        println("schedule a job: " + LocalDateTime.now())

        Timer().scheduleAtFixedRate(1000, 3000) {
            println("running a job: " + LocalDateTime.now())
        }

        println("done: " + LocalDateTime.now())
    }

    @Test
    fun test4() {
        println("schedule a job: " + LocalDateTime.now())

        Timer().scheduleAtFixedRate( object : TimerTask() {
            override fun run() {
                println("running a job: " + LocalDateTime.now())
            }
        }, 1000, 3000)

        println("done: " + LocalDateTime.now())
    }


}

