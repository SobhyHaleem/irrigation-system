package com.sobhy.system.irrigationsystem.contracts;

import com.sobhy.system.irrigationsystem.entities.TimeSlot;

public interface ITimeSlotService {

    TimeSlot findTimeSlotById(Long timeSlotId) throws Exception;

}
