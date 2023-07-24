package com.sobhy.system.irrigationsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class SensorStatusDto {
    private Long id;
    private boolean irrigated;
}
