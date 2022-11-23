package com.study.kotlininactionpractice.notInBooks.encryption

import com.google.common.io.BaseEncoding
import com.google.common.primitives.Longs
import org.junit.jupiter.api.Test

class EncryptionTest {

    // Longs와 toByteArray, BaseEncoding, base64Url 출처
    // Guava: Google Core Libraries for Java
    @Test
    fun contextLoads() {
        val data: Long = 234423424L
        val bytes = Longs.toByteArray(data)
        val encoded = BaseEncoding.base64Url().omitPadding().encode(bytes)
        println(encoded)
        println(Longs.fromByteArray(BaseEncoding.base64Url().omitPadding().decode(encoded)))
    }

}
