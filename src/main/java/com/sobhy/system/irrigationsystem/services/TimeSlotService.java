package com.sobhy.system.irrigationsystem.services;

import com.sobhy.system.irrigationsystem.contracts.ITimeSlotService;
import com.sobhy.system.irrigationsystem.entities.TimeSlot;
import com.sobhy.system.irrigationsystem.repositories.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TimeSlotService implements ITimeSlotService {
    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @Override
    public TimeSlot findTimeSlotById(Long timeSlotId) throws Exception {
        Optional<TimeSlot> timeSlot = timeSlotRepository.findById(timeSlotId);
        if (!timeSlot.isPresent())
            throw new Exception("TimeSlot couldn't be found!");

        return timeSlot.get();
    }
}
