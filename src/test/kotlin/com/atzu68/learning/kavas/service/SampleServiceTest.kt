package com.atzu68.learning.kavas.service

import com.atzu68.learning.kavas.configuration.SampleConfiguration
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith


@ExtendWith(MockKExtension::class)
class SampleServiceTest {

    @MockK
    lateinit var sampleConfiguration: SampleConfiguration

    lateinit var sampleService: SampleService

    @BeforeEach
    fun setUp() {
        sampleService = SampleService(sampleConfiguration)
    }

    @Test
    fun shouldReturnSampleListSuccessfully() {

        val pair = SampleConfiguration.KeyValuePair()
        pair.key = "testKey"
        pair.value = "testValue"

        every { sampleConfiguration.sampleList } returns listOf(pair)

        val returnedList = sampleService.sampleList

        assertThat(returnedList, notNullValue())
        assertThat(returnedList, not(empty()))
        assertThat(returnedList[0], notNullValue())
        assertThat(returnedList[0].key, notNullValue())
        assertThat(returnedList[0].key, equalTo("testKey"))
        assertThat(returnedList[0].value, notNullValue())
        assertThat(returnedList[0].value, equalTo("testValue"))
    }

}