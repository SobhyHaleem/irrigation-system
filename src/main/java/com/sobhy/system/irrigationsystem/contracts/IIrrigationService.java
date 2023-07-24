package com.sobhy.system.irrigationsystem.contracts;

import com.sobhy.system.irrigationsystem.entities.TimeSlot;

public interface IIrrigationService {

    void irrigate(TimeSlot timeSlot);
}
