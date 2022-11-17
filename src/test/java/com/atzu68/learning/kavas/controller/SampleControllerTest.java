package com.atzu68.learning.kavas.controller;

import com.atzu68.learning.kavas.configuration.SampleConfiguration;
import com.atzu68.learning.kavas.service.SampleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@WebMvcTest(KSampleController.class)
public class SampleControllerTest {

    private static final String SAMPLE_URL = "/api/kotlin/test/";

    @MockBean
    private SampleService sampleService;

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldReturnSampleListSuccessfullyWithRightPathValue() throws Exception {
        var pair = new SampleConfiguration.KeyValuePair();
        pair.setKey("testKey");
        pair.setValue("testValue");

        when(sampleService.getSampleList()).thenReturn(List.of(pair));

        mvc.perform(get(SAMPLE_URL + "right-path-value").contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.returnedListKey_kotlin", is(notNullValue())))
                .andExpect(jsonPath("$.returnedListKey_kotlin[0].key", is("testKey")))
                .andExpect(jsonPath("$.returnedListKey_kotlin[0].value", is("testValue")));

        verify(sampleService).getSampleList();
    }

    @Test
    public void shouldReturnSampleListSuccessfullyWithOtherPathValue() throws Exception {
        var pair = new SampleConfiguration.KeyValuePair();
        pair.setKey("testKey");
        pair.setValue("testValue");

        when(sampleService.getSampleList()).thenReturn(List.of(pair));

        mvc.perform(get(SAMPLE_URL + "other-path-value").contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("{}"));
    }

}
