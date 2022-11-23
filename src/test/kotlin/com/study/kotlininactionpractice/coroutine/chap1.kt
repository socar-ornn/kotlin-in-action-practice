package com.study.kotlininactionpractice.coroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.* // measureTimeMillis
import org.junit.jupiter.api.Test

class chap1 {

    @Test
    fun `suspend를 사용하였을 경우, 하나의 스레드가 blocking되지 않고 완료를 기다린다`() {
        runBlocking{
            val time = measureTimeMillis {
                val name = getName()
                println("여기는 중간이야")
                val lastName = getLastName()
                println("Hello, $name $lastName")
            }
            println("Execution took $time ms")
        }
    }

    @Test
    fun `동시에 수행해보자`() {
        runBlocking {
            val time = measureTimeMillis {
                val name = async { getName() }
                println("여기는 중간이야")
                val lastName = async { getLastName() }
                println("Hello, ${name.await()} ${lastName.await()}")
            }
            println("Execution took $time ms")
        }
    }

    suspend fun getName(): String {
        delay(1000)
        println("getName()")
        return "Susan"
    }
    suspend fun getLastName(): String {
        delay(1000)
        println("getLastName()")
        return "Calvin"
    }
}
