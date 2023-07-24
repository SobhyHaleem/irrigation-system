package com.sobhy.system.irrigationsystem.utilities.mappers;

import com.sobhy.system.irrigationsystem.entities.TimeSlot;
import com.sobhy.system.irrigationsystem.models.TimeSlotDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TimeSlotMapper {

    public TimeSlot toTimeSlotEntity(TimeSlotDto timeSlotDto) {
        if (timeSlotDto == null) {
            return null;
        } else {
            ModelMapper modelMapper = new ModelMapper();
            TimeSlot timeSlot = modelMapper.map(timeSlotDto, TimeSlot.class);
            return timeSlot;
        }
    }

    public TimeSlotDto toTimeSlotModel(TimeSlot timeSlot) {
        if (timeSlot == null) {
            return null;
        } else {
            ModelMapper modelMapper = new ModelMapper();
            TimeSlotDto timeSlotDto = modelMapper.map(timeSlot, TimeSlotDto.class);
            return timeSlotDto;
        }
    }
}
