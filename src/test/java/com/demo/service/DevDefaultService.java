package com.demo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DevDefaultService implements DefaultService {
    @Override
    public void printServiceName() {
        System.out.println("DevDefaultService");
    }
}
