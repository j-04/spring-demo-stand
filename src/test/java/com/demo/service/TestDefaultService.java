package com.demo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("test")
public class TestDefaultService implements DefaultService {
    @Override
    public void printServiceName() {
        System.out.println("TestService");
    }
}
