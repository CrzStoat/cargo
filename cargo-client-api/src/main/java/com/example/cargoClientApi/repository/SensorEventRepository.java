package com.example.cargoClientApi.repository;

import com.example.cargoClientApi.models.SensorEvent;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface SensorEventRepository extends CassandraRepository<SensorEvent, Long> {
}
