package ru.romananchugov.filmsmvvm.domain

import org.junit.Test

import org.junit.Assert.*
import ru.romananchugov.filmsmvvm.domain.use_case.BaseUseCase

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @BaseUseCase
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}
