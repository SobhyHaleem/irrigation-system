package com.sobhy.system.irrigationsystem.models;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Slf4j
public class PlotDto {
    private Long id;
    private String plotName;
    private List<TimeSlotDto> timeSlots;
}
