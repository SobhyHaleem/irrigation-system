package com.sobhy.system.irrigationsystem.contracts;

public interface IAlertService {

    void handleExceededRetryAttempts(Long timeSlotId);

    void handleSensorDeviceNotAvailable(Long timeSlotId);
}
