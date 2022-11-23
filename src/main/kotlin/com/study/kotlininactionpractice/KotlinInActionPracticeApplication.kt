package com.study.kotlininactionpractice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinInActionPracticeApplication

fun main(args: Array<String>) {

    println("${Thread.currentThread()}: run the thread")

    val myThread = MyThread()
    myThread.start()

    println("${Thread.currentThread()}: wait until the thread is done")
    myThread.join()

    // ------
    println("${Thread.currentThread()}: run the thread")

    val myRunnableThread = Thread(MyRunnable())
    myRunnableThread.start()

    println("${Thread.currentThread()}: wait until the thread is done")
    myRunnableThread.join()
//    runApplication<KotlinInActionPracticeApplication>(*args)

}

class MyThread : Thread() {
    public override fun run() {
        println("${Thread.currentThread()}: it's running.")
    }
}

class MyRunnable: Runnable {
    public override fun run() {
        println("${Thread.currentThread()}: it's running.")
    }
}
