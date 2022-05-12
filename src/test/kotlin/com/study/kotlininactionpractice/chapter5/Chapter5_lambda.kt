package com.study.kotlininactionpractice.chapter5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class chapter5_lambda {
    @Test
    fun `테스트_진행`() {
        // given
        val greet = " 안녕하세요 "

        // when
        val removedSurroundings = greet.removeSurrounding(" ")

        // then
        assertThat(removedSurroundings.length).isEqualTo("안녕하세요".length)
    }


}
