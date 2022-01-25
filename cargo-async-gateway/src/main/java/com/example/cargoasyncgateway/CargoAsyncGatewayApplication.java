package com.example.cargoasyncgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.example.cargoClientApi.repository"})
public class CargoAsyncGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CargoAsyncGatewayApplication.class, args);
    }

}
