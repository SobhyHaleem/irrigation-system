package com.sobhy.system.irrigationsystem.controllers;

import com.sobhy.system.irrigationsystem.contracts.IIrrigationService;
import com.sobhy.system.irrigationsystem.contracts.ITimeSlotService;
import com.sobhy.system.irrigationsystem.entities.TimeSlot;
import com.sobhy.system.irrigationsystem.utilities.exceptions.SensorDeviceNotAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/irrigation")
public class IrrigationController {

    @Autowired
    private IIrrigationService iIrrigationService;

    @Autowired
    private ITimeSlotService iTimeSlotService;


    @PostMapping("/irrigate/{timeSlotId}")
    public ResponseEntity<String> irrigateTimeSlot(@PathVariable Long timeSlotId) throws Exception {
        // Fetch the TimeSlot from the database using the timeSlotId
        TimeSlot timeSlot = iTimeSlotService.findTimeSlotById(timeSlotId);

        try {
            iIrrigationService.irrigate(timeSlot);
            return ResponseEntity.ok("Irrigation successful for TimeSlot ID: " + timeSlotId);
        } catch (SensorDeviceNotAvailableException ex) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body("Sensor device not available for TimeSlot ID: " + timeSlotId);
        }
    }
}
