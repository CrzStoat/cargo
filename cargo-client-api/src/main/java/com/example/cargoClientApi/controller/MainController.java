package com.example.cargoClientApi.controller;

import com.example.cargoClientApi.models.SensorEvent;
import com.example.cargoClientApi.repository.SensorEventRepository;
import com.example.cargoClientApi.models.Sensor;
import com.example.cargoClientApi.models.User;
import com.example.cargoClientApi.repository.SensorRepository;
import com.example.cargoClientApi.repository.UserRepository;
import com.example.cargoClientApi.pojo.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MainController {

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SensorEventRepository sensorEventRepository;

    @GetMapping("/get_s")
    public ResponseEntity<List<Sensor>> getSensors() {
        return ResponseEntity.ok(sensorRepository.findAll());
    }

    @GetMapping("/get_u")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/get_se")
    public ResponseEntity<List<SensorEvent>> getSensorEvents() {
        return ResponseEntity.ok(sensorEventRepository.findAll());
    }

    @PostMapping("/post")
    public ResponseEntity<?> postSensorEvent(@RequestParam("id") String sensorId, @RequestParam("value") String sensorValue){
        try {
            sensorEventRepository.save(new SensorEvent(Long.valueOf(sensorId), Long.valueOf(sensorValue)));
        }catch (NumberFormatException e){
            return ResponseEntity.badRequest()
                    .body(new MessageResponse(("Id and value should be number (Long)")));
        }

        return ResponseEntity.ok("SensorEvent added");
    }


}
