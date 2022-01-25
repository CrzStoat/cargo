package com.example.cargoasyncgateway.controller;

import com.example.cargoClientApi.models.SensorEvent;
import com.example.cargoasyncgateway.kafka.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    private KafkaSender kafkaSender;

    @PostMapping("/post")
    public ResponseEntity<?> messageToTopic(@RequestBody SensorEvent sensorEvent){
        kafkaSender.send(sensorEvent);
        return ResponseEntity.ok("SensorEvent successfully added!");
    }
}
