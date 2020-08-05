package com.demo.config;

import com.demo.service.DefaultService;
import com.demo.service.DevDefaultService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.demo.service")
public class SpringConfiguration {
    @Bean
    public DefaultService devDefaultService() {
        return new DevDefaultService();
    }
}
