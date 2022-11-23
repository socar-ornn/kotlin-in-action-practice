package com.study.kotlininactionpractice.notInBooks.javaTimePackage

import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import java.time.Instant
import java.time.Year
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class InstantTest {
    // Instant클래스는 시간을 타임스탬프로 다루기 위해 사용한다
    // 출처: https://www.daleseo.com/java8-instant/

    val logger = LoggerFactory.getLogger(InstantTest::class.java.name)

    @Test
    fun Instant는_ofEpochSecond_라는_정적펙토리_메소드로_생성할_수_있다() {
        val epoch = java.time.Instant.EPOCH // Instant.ofEpochSecond(0)
        logger.info("epoch = ${epoch}")

        val epochInFuture = Instant.ofEpochSecond(1_000_000_000)
        logger.info("epochInFuture = ${epochInFuture}")

        val epochInPast = Instant.ofEpochSecond(-1_000_000_000)
        logger.info("epochInFuture = ${epochInPast}")
    }

    @Test
    fun Instant는_now_메소드로_현재시간으로_인스턴스_생성이_가능하고_Instant를_Long타입의_epochSecond형태로_변환할수도_있다() {
        val current = java.time.Instant.now()
        logger.info("current = ${current}")

        val epochSecond = current.epochSecond
        logger.info("epochSecond = ${epochSecond}")
    }

    @Test
    fun Instant와_ZonedDateTime_간_상호_변환하기() {
        val localDateTime = Year.of(2022).atMonth(6).atDay(25).atTime(20, 30)

        // LocalDateTime -> ZoneDateTime
        val zdtSeoul = localDateTime.atZone(ZoneId.of("Asia/Seoul"))
        logger.info("Time in Seoul =  $zdtSeoul")

        // ZoneDateTime -> Instant
        val seoulZoneTimeInstant = zdtSeoul.toInstant() // 사을 기준 시각을 Instant로 바꾸면 UTC기준 시간이 되기 때문에 9시간 느린 값이 된다.
        logger.info("seoulZoneTime = $seoulZoneTimeInstant, seoulZoneTimeEpochSecond = ${seoulZoneTimeInstant.epochSecond}")
    }

    @Test
    fun Instant와_LocalDateTime_간_상호_변환하기() {
        val localDateTime = Year.of(2022).atMonth(6).atDay(25).atTime(20, 30)

        // LocalDateTime -> Instant
        val zdtUTC = localDateTime.toInstant(ZoneOffset.UTC)
        val zdtKR = localDateTime.toInstant(ZoneOffset.ofHours(9))

        logger.info("britishTime =  $zdtUTC, britishZoneTimeEpochSecond = ${zdtUTC.epochSecond}")
        logger.info("koreaTime =  $zdtKR, koreaTimeEpochSecond = ${zdtKR.epochSecond}")
    }

    @Test
    fun `dateTimeFormmater로 날짜 출력형식 변경하기`() {
        // given
        val now = Instant.now()
        val dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd HH:mm").withZone(ZoneId.of("Asia/Seoul"))

        // when
        val formattedTime = dateTimeFormatter.format(now)

        // then
        logger.info(formattedTime)
    }
}






















