package com.example.cargoProcessor.kafka;

import com.example.cargoClientApi.models.SensorEvent;
import com.example.cargoClientApi.repository.SensorEventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;


@EnableKafka
@Service
@Slf4j
public class KafkaReceiver {
    private static final String TOPIC = "sensor_event";
    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private SensorEventRepository sensorEventRepository;

    @KafkaListener(topics = TOPIC, groupId = "group_id")
    public void receive(SensorEvent sensorEvent) {
        log.info("received sensorId='{}', sensorValue='{}'", sensorEvent.getSensorId(), sensorEvent.getSensorValue());
        sensorEventRepository.save(sensorEvent);
        latch.countDown();
    }
}
