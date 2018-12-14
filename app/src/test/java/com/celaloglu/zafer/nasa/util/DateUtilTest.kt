package com.celaloglu.zafer.nasa.util

import junit.framework.Assert.assertEquals
import org.junit.Test

class DateUtilTest {

    private val date = "2018-12-07"

    @Test
    fun should_return_seven_december_date() {
        // when
        val result = getDate()
        // then
        assertEquals(date, result)
    }
}