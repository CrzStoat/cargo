package com.example.cargoemulator.service;

import com.example.cargoClientApi.models.Sensor;
import com.example.cargoClientApi.models.SensorEvent;
import com.example.cargoClientApi.repository.SensorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
@Slf4j
@EnableScheduling
public class SensorEventSender {
    @Value("${cargo.async-gateway.api.url}" + "/post")
    private String gatewayApiUrl;
    @Value("${cargo.async-gateway.apikey.key}")
    private String gatewayAuthKey;
    @Value("${cargo.async-gateway.apikey.value}")
    private String gatewayAuthValue;

    @Autowired
    private SensorRepository sensorRepository;

    @Scheduled(fixedDelay = 1000)
    public void scheduleSendSensorEvent() {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add(gatewayAuthKey, gatewayAuthValue);

        SensorEvent body = generateRandomSensorEvent();

        HttpEntity<SensorEvent> request = new HttpEntity<>(body, headers);
        log.info("post SensorEvent: sensorId={}, sensorValue={}", body.getSensorId(), body.getSensorValue());
        restTemplate.exchange(gatewayApiUrl, HttpMethod.POST, request, String.class);
    }

    private SensorEvent generateRandomSensorEvent() {
        var countOfSensors = sensorRepository.count();
        var randomSensorId = random(0, countOfSensors);
        Page<Sensor> sensorPage = sensorRepository.findAll(PageRequest.of((int) randomSensorId, 1));
        if (sensorPage.hasContent()) {
            var sensorId = sensorPage.getContent().get(0).getId();
            return new SensorEvent(sensorId, random(0, 100));
        }
        return new SensorEvent(1L, random(0, 100));
    }

    private long random(long min, long max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
