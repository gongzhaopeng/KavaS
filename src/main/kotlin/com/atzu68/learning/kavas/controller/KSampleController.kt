package com.atzu68.learning.kavas.controller

import com.atzu68.learning.kavas.service.SampleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/kotlin")
class KSampleController(private val sampleService: SampleService) {

    @GetMapping("/test/{samplePathVariable}")
    fun getSampleList(@PathVariable samplePathVariable: String): Map<String, Any> = when (samplePathVariable) {
        "right-path-value" -> hashMapOf("returnedListKey_kotlin" to sampleService.sampleList)
        else -> hashMapOf()
    }

}
