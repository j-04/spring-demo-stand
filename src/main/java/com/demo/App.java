package com.demo;

import com.demo.util.DataInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class App implements CommandLineRunner {
    private DataInitializer dataInitializer;

    @Autowired
    public void setDataInitializer(DataInitializer dataInitializer) {
        this.dataInitializer = dataInitializer;
    }
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        dataInitializer.insertPersonsToDataBase();
    }
}
