package com.study.kotlininactionpractice.notInBooks.javaTimePackage

import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import java.time.LocalDate
import java.time.Period

class PeriodTest {
    // 학습 출처: https://www.daleseo.com/java8-duration-period/

    val logger = LoggerFactory.getLogger(PeriodTest::class.java)

    @Test
    fun Period는_LocalDate를_통해서_생성할_수_있다() {
        // Period는 두 날짜사이의 간격을 년/월/일 단위로 나타낼수 있고 (Not 시간 !!)
        // 두 LocalDate 를 통해서 구할 수 있다.

        val startDate: LocalDate = LocalDate.of(1939, 9, 1)
        val endDate: LocalDate = LocalDate.of(1945, 9, 2)

        val period: Period = Period.between(startDate, endDate)

        logger.info("Years: ${period.years}")
        logger.info("Months: " + period.months)
        logger.info("Days: " + period.days)
    }

    @Test
    fun Period는_of_정적팩토리_메서드로_생성이가능하다_plus로_기간을_더할수도_있다() {
        val period = Period.of(1, 11, 10)
        logger.info("period.years = ${period.years}")
        logger.info("period.months = ${period.months}")
        logger.info("period.days = ${period.days}")

        val plusPeriod = period.plus(Period.ofYears(2))
        logger.info("plusPeriod.years = ${plusPeriod.years}")
        logger.info("plusPeriod.months = ${plusPeriod.months}")
        logger.info("plusPeriod.days = ${plusPeriod.days}")
    }
}
