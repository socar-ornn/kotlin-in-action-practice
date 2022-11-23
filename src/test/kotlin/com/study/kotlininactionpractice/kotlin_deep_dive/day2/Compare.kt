package com.study.kotlininactionpractice.kotlin_deep_dive.day2

import org.junit.jupiter.api.Test
import java.util.Date

class Compare {

    @Test
    fun compareWith() {
        val list = listOf("apple", "banana", "kiwi", "orange", "watermelon")

        val alphabetOrder = list.sorted()
        println("Alphabet order: $alphabetOrder")

        val comparator : Comparator<String> = compareBy { it.length }
        val lengthOrder = list.sortedWith(comparator)
        println("Length order: $lengthOrder")
    }

    @Test
    fun compareWith2() {
        val dates = mutableListOf(
            Date(2020, 4, 3),
            Date(2021, 5, 16),
            Date(2020, 4, 29)
        )

        dates.sortWith(compareBy<Date> { it.year }.thenBy { it.month }.thenBy { it.day })

        dates.forEach { println(it) }
    }

    @Test
    fun sortedBy() {
        val list = mutableListOf("d" to 4, "a" to 10, "c" to 8, "h" to 5)
        println("list: $list")

        list.sortBy { it.first }
        println("sortByFirst: $list")

        list.sortBy { it.second }
        println("sortBySecond: $list")
    }

    @Test
    fun reverseAndReversed() {
        // 1. immutable list
        val list = listOf(10, 100, 50, 2, 77, 4)
        val sorted = list.sorted().reversed()
        println("sorted : $sorted")

        // 2. mutable list
        val list2 = mutableListOf(10, 100, 50, 2, 77, 4)
        list2.sort()
        list2.reverse()
        println("sorted : $list2")
    }
}
