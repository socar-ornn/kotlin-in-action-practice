package com.study.kotlininactionpractice.kotlin_deep_dive.day1

import org.junit.jupiter.api.Test

class ThreadTest {

    class MyThread: Thread() {
        public override fun run() {
            println("${Thread.currentThread()}: it's running.")
        }
    }

    @Test
    fun test() {
        println("${Thread.currentThread()}: run the thread")

        val myThread = MyThread()
        myThread.start()

        println("${Thread.currentThread()}: wait until the thread is done")
        myThread.join()
    }
}
