package com.atzu68.learning.kavas.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "sample-conf")
open class SampleConfiguration {

    lateinit var title: String
    lateinit var sampleList: List<KeyValuePair>

    class KeyValuePair {

        lateinit var key: String
        lateinit var value: String

    }

}