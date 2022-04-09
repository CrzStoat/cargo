package com.example.cargoClientApi.service;

import com.example.cargoClientApi.pojo.SensorInfo;

import java.util.List;

public interface SensorsService {
    List<SensorInfo> getSensorsInfoByPage(int page, int pageSize);

    SensorInfo getSensorInfoById(int id);
}
