package com.example.cargoClientApi.controller;

import com.example.cargoClientApi.pojo.SensorInfo;
import com.example.cargoClientApi.service.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SensorController {
    @Autowired
    SensorsService sensorsService;

    @GetMapping("/sensors-info/get")
    public ResponseEntity<List<SensorInfo>> getSensorEventsByPage(@RequestParam("page") int page,
                                                            @RequestParam("page_size") int pageSize) {

        return ResponseEntity.ok(sensorsService.mapSensorsWithEventsToInfo(page, pageSize));
    }

}
