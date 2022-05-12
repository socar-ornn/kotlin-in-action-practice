package com.study.kotlininactionpractice.notInBooks.javaTimePackage

import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import java.time.Duration
import java.time.LocalTime

class DurationTest {
    // 학습 출처: https://www.daleseo.com/java8-duration-period/

    val logger = LoggerFactory.getLogger(DurationTest::class.java.name)

    @Test
    fun Duration은_LocalTime을_통해서_생성할_수_있다() {
        // Duration 클래스를 통해 제어할 수 있는 가장 큰 시간 단위는 '일'이다.
        // Duration은 두 LocalTime을 통해 만들 수 있다.
        val start = LocalTime.of(10, 35, 40) // 10시 35분 40초
        val end = LocalTime.of(10, 36, 50, 800) // 10시 36분 50.000_0008초

        val duration = java.time.Duration.between(start, end)

        logger.info("duration.seconds = ${duration.seconds}")
        logger.info("duration.nano = ${duration.nano}")
    }

    @Test
    fun Duration은_of_정적펙토리_메서드로_생성할_수_있다() {
        val ofMinutes = Duration.ofMinutes(1)
        logger.info("1 minute is ${ofMinutes.seconds} seconds\n")

        val ofHours = Duration.ofHours(1)
        logger.info("1 hour is ${ofHours.seconds} seconds\n")

        val ofDays = Duration.ofDays(1)
        logger.info("1 day is ${ofDays.seconds} seconds\n" )
    }
}
