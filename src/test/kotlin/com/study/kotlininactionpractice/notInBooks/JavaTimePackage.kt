package com.study.kotlininactionpractice.notInBooks

import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.LocalTime
import java.time.Period
import java.time.Duration
import java.time.Instant
import java.time.Year
import java.time.ZoneId

class JavaTimePackage {





    @Test
    fun Instant() {
        val epoch = Instant.EPOCH // Instant.ofEpochSecond(0)
        println("epoch = ${epoch}")

        val epochInFuture = Instant.ofEpochSecond(1_000_000_000)
        println("epochInFuture = ${epochInFuture}")

        val epochInPast = Instant.ofEpochSecond(-1_000_000_000)
        println("epochInFuture = ${epochInPast}")
    }

    @Test
    fun Instant2() {
        val current = Instant.now()
        println("current = ${current}")

        val epochSecond = current.epochSecond
        println("epochSecond = ${epochSecond}")
    }

    @Test
    fun Instant3() {
        // Instant와 ZonedDateTime 간 상호 변환하기
        val zdtSeoul = Year.of(2022).atMonth(6).atDay(25).atTime(20, 30).atZone(ZoneId.of("Asia/Seoul"))
        System.out.println("Time in Seoul = " + zdtSeoul);
    }
}
