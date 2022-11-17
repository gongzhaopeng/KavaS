package com.atzu68.learning.kavas.controller;

import com.atzu68.learning.kavas.service.SampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/java")
public class JSampleController {

    private final SampleService sampleService;

    public JSampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("/test/{samplePathVariable}")
    public Map<String, Object> getSampleList(@PathVariable String samplePathVariable) {
        if ("right-path-value".equals(samplePathVariable)) {
            return Map.of("returnedListKey_java", sampleService.getSampleList());
        } else {
            return Map.of();
        }
    }

}
