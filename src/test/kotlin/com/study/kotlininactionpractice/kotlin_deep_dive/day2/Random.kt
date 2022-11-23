package com.study.kotlininactionpractice.kotlin_deep_dive.day2

import org.junit.jupiter.api.Test
import java.security.SecureRandom
import java.util.concurrent.ThreadLocalRandom

class Random {

    @Test
    fun mathRandom() {
        println(Math.random())  // 0 <= n < 1

        println(Math.random())

        println(Math.random())
    }

    @Test
    fun rangeRandom() {
        val range = (1..15)  // 1 <= n <= 15
        println(range.random())
        println(range.random())

        val random = (1..20).random()  // 1 <= n <= 20
        println(random)
    }

    @Test
    fun threadLocalRandom() {
        val randomDouble = ThreadLocalRandom.current().nextDouble(1.0, 10.0)
        val randomInteger = ThreadLocalRandom.current().nextInt(1, 10)
        val randomLong = ThreadLocalRandom.current().nextLong(1, 10)

        println(randomDouble)  // 1 <= n < 10.0
        println(randomInteger)  // 1 <= n < 10
        println(randomLong)  // 1 <= n < 10
    }

    // 위에서 소개한 방법들은 정해진 패턴으로 랜덤 숫자를 생성합니다. 그렇기 때문에 패턴을 찾아 생성되는 숫자를 예측할 수 있습니다.
    // SecureRandom`은 예측이 불가능한 랜덤 숫자를 생성하여 Security 측면에서 좋습니다.
    @Test
    fun secureRandom() {
        val secureRandom = SecureRandom()

        println(secureRandom.nextInt(100))  // 0 <= n < 100
        println(secureRandom.nextDouble())
    }
}
