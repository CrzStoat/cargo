package com.example.cargoProcessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@EnableCassandraRepositories("com.example.cargoClientApi.repository")
public class CargoProcessorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CargoProcessorApplication.class, args);
    }

}
