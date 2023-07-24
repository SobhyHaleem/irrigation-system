package com.sobhy.system.irrigationsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class TimeSlotDto {
    private Long id;
    private Timestamp startTime;
    private Timestamp endTime;
}
