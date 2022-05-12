package com.study.kotlininactionpractice.notInBooks.javaTimePackage

import org.junit.jupiter.api.Test
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import org.slf4j.LoggerFactory
import java.time.LocalDateTime

class ZonedDateTimeTest {

    val logger = LoggerFactory.getLogger(ZonedDateTimeTest::class.java.name)

    // ZoneOffset은 시차를 의미한다. (ZoneId는 타임존을 의미)
    // 출처: https://www.daleseo.com/java8-zoned-date-time/
    @Test
    fun ZoneOffset과_ZoneId를_이용하여_서울의_시간을_구할_수_있다() {
        val seoulZoneDateTime1 = ZonedDateTime.now(ZoneOffset.of("+09:00"))
        val seoulZoneDateTime2 = ZonedDateTime.now(ZoneId.of("Asia/Seoul"))
        logger.info("$seoulZoneDateTime1")
        logger.info("$seoulZoneDateTime2")
    }

    /**
     *  .atTime으로 LocalDateTime 객체가 만들어지면
     *  .atZone(ZoneId.of("Asia/Seoul"))을 붙여서 ZonedDateTime으로 변환할 수 있다.
     **/
    @Test
    fun LocalDateTime을_ZonedDateTime으로_변환_할_수_있다() {
        val now = LocalDateTime.now()
        val nowZonedDateTime = now.atZone(ZoneId.of("Asia/Seoul"))

        logger.info("$now")
        logger.info("$nowZonedDateTime")
    }
}
