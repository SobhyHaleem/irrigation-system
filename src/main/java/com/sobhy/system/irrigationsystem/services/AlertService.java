package com.sobhy.system.irrigationsystem.services;

import com.sobhy.system.irrigationsystem.contracts.IAlertService;
import com.sobhy.system.irrigationsystem.entities.Alert;
import com.sobhy.system.irrigationsystem.models.Product;
import com.sobhy.system.irrigationsystem.repositories.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class AlertService implements IAlertService {
    @Autowired
    private AlertRepository alertRepository;
    private final int maxRetryAttempts = 3; // Maximum retry attempts before generating an alert

    @Override
    public void handleSensorDeviceNotAvailable(Long timeSlotId) {
        String message = "Sensor device not available for TimeSlot ID: " + timeSlotId;
        createAlert(message);
    }

    @Override
    public void handleExceededRetryAttempts(Long timeSlotId) {
        String message = "Exceeded maximum retry attempts for TimeSlot ID: " + timeSlotId;
        createAlert(message);
    }

    private void createAlert(String message) {
        Alert alert = new Alert();
        alert.setTimestamp(new Timestamp(new Date().getTime()));
        alert.setMessage(message);
        alertRepository.save(alert);
    }
}
