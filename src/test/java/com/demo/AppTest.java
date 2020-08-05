package com.demo;

import com.demo.service.DefaultService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
public class AppTest {
    @TestConfiguration
    @ComponentScan("com.demo.service")
    @PropertySources(value = {
            @PropertySource("classpath:/application.properties"),
            @PropertySource("classpath:/application-default.properties"),
            @PropertySource("classpath:/application-dev.properties")
    })
    static class TestSpringConfiguration {
    }

    @Value("${name}")
    private String name;

    private DefaultService defaultService;

    @Autowired
    public void setService(DefaultService defaultService) {
        this.defaultService = defaultService;
    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testPrintServiceName() {
        defaultService.printServiceName();
    }

    @Test
    public void testPrintName() {
        System.out.println(name);
    }
}
