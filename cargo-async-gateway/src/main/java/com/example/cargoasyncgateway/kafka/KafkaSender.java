package com.example.cargoasyncgateway.kafka;

import com.example.cargoClientApi.models.SensorEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaSender {
    private static final String TOPIC = "sensor_event";

    @Bean
    public NewTopic createTopic() {
        return new NewTopic(TOPIC, 3, (short) 1);
    }

    @Autowired
    private KafkaTemplate<String, SensorEvent> kafkaTemplate;

    public void send(SensorEvent sensorEvent) {
        log.info("sending sensorId='{}', sensorValue='{}'", sensorEvent.getSensorId(), sensorEvent.getSensorValue());
        kafkaTemplate.send(TOPIC, sensorEvent);
    }
}
