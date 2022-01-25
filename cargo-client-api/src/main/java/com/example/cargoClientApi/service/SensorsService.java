package com.example.cargoClientApi.service;

import com.example.cargoClientApi.pojo.SensorInfo;

import java.util.List;

public interface SensorsService {
    List<SensorInfo> mapSensorsWithEventsToInfo(int page, int pageSize);
}
