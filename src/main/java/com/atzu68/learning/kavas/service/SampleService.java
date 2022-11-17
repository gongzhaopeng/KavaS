package com.atzu68.learning.kavas.service;

import com.atzu68.learning.kavas.configuration.SampleConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService {

    private final SampleConfiguration sampleConfiguration;

    public SampleService(SampleConfiguration sampleConfiguration) {
        this.sampleConfiguration = sampleConfiguration;
    }

    public List<SampleConfiguration.KeyValuePair> getSampleList() {
        return sampleConfiguration.getSampleList();
    }

}
