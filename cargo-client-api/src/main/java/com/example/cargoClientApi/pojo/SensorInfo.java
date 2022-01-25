package com.example.cargoClientApi.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class SensorInfo {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate registrationDate;
    private Long value;
}
