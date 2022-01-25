package com.example.cargoemulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.cargoClientApi.repository")
@EntityScan(basePackages = "com.example.cargoClientApi.models")
public class CargoEmulatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CargoEmulatorApplication.class, args);
    }


}
