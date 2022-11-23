package com.study.kotlininactionpractice.kotlin_deep_dive.day1

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit

class SleepTest {

    @Test
    fun test1() {

        println("sleep for 3s: " + LocalDateTime.now())

        try {
            Thread.sleep(3000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        println("done: " + LocalDateTime.now())
    }

    @Test
    fun test2() {
        println("sleep for 3s: " + LocalDateTime.now())

        try {
            TimeUnit.SECONDS.sleep(3)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        println("done: " + LocalDateTime.now())
    }

    @Test
    fun test3() {
        println("sleep for 3s: " + LocalDateTime.now())

        runBlocking {
            launch {
                delay(3000L)
            }
        }

        println("done: " + LocalDateTime.now())
    }
}
