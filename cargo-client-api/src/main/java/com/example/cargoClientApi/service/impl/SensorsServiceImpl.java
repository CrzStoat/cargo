package com.example.cargoClientApi.service.impl;

import com.example.cargoClientApi.models.Sensor;
import com.example.cargoClientApi.models.SensorEvent;
import com.example.cargoClientApi.pojo.SensorInfo;
import com.example.cargoClientApi.repository.SensorEventRepository;
import com.example.cargoClientApi.repository.SensorRepository;
import com.example.cargoClientApi.service.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SensorsServiceImpl implements SensorsService {

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private SensorEventRepository sensorEventRepository;

    public List<SensorInfo> mapSensorsWithEventsToInfo(int page, int pageSize) {
        Page<Sensor> sensorPage = sensorRepository.findAll(PageRequest.of(page, pageSize));
        return sensorPage.getContent().parallelStream()
                .map(sensor -> new SensorInfo(
                                sensor.getId(),
                                sensor.getRegistrationDate(),
                                sensorEventRepository.findById(sensor.getId())
                                        .map(SensorEvent::getSensorValue).orElse(null)
                        )
                ).collect(Collectors.toList());
    }
}
