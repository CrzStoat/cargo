package com.example.cargoClientApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
public class CargoClientApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CargoClientApiApplication.class, args);
    }

}
