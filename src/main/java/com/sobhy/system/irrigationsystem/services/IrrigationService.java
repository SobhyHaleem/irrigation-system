package com.sobhy.system.irrigationsystem.services;

import com.sobhy.system.irrigationsystem.contracts.IIrrigationService;
import com.sobhy.system.irrigationsystem.entities.SensorStatus;
import com.sobhy.system.irrigationsystem.entities.TimeSlot;
import com.sobhy.system.irrigationsystem.repositories.SensorStatusRepository;
import com.sobhy.system.irrigationsystem.utilities.exceptions.SensorDeviceNotAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

@Service
public class IrrigationService implements IIrrigationService {
    private final SensorStatusRepository sensorStatusRepository;
    private final AlertService alertService;
    private final IrrigationPredictionService predictionService;
    private final RetryTemplate retryTemplate;
    private final int maxRetryAttempts = 3;

    @Autowired
    public IrrigationService(SensorStatusRepository sensorStatusRepository, AlertService alertService, IrrigationPredictionService predictionService) {
        this.sensorStatusRepository = sensorStatusRepository;
        this.alertService = alertService;
        this.retryTemplate = createRetryTemplate();
        this.predictionService = predictionService;
    }

    @Override
    public void irrigate(TimeSlot timeSlot) {
        try {
            // Simulate calling the sensor device (will replace this with actual API call)
            callSensorDevice(timeSlot);
            // Update the status of the time slot once the request is successfully sent to the sensor device
            updateSensorStatus(timeSlot, true);
        } catch (SensorDeviceNotAvailableException ex) {
            // Retry the call to the sensor device in case it's not available
            int currentRetryAttempts = 0;
            while (currentRetryAttempts < maxRetryAttempts) {
                try {
                    // Simulate calling the sensor device again (replace with actual API call)
                    callSensorDevice(timeSlot);
                    // Update the status of the time slot once the request is successfully sent to the sensor device
                    updateSensorStatus(timeSlot, true);
                    return; // Exit the method if the irrigation is successful after retry
                } catch (SensorDeviceNotAvailableException e) {
                    currentRetryAttempts++;
                }
            }
            // If maximum retry attempts are reached without successful irrigation, generate an alert
            alertService.handleExceededRetryAttempts(timeSlot.getId());
        }
    }

    private void callSensorDevice(TimeSlot timeSlot) throws SensorDeviceNotAvailableException {
        // Simulate calling the sensor device (replace this with actual API call)
        // In this example, we'll assume the sensor device is not available sometimes
        if (isSensorAvailable()) {
            // If the sensor is available, the irrigation process will be successful.
            System.out.println("Sensor device called successfully for TimeSlot ID: " + timeSlot.getId());
        } else {
            throw new SensorDeviceNotAvailableException("Sensor device is not available.");
        }
    }

    private boolean isSensorAvailable() {
        // Simulate the sensor availability (you can implement the logic based on real sensor status)
        return Math.random() < 0.8; // 80% chance of the sensor being available
    }

    private void updateSensorStatus(TimeSlot timeSlot, boolean irrigated) {
        SensorStatus sensorStatus = timeSlot.getSensorStatus();
        if (sensorStatus == null) {
            sensorStatus = new SensorStatus();
            sensorStatus.setTimeSlot(timeSlot);
        }
        sensorStatus.setIrrigated(irrigated);
        sensorStatusRepository.save(sensorStatus);
    }

    private RetryTemplate createRetryTemplate() {
        // Create and configure the retry template
        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(3); // Maximum number of retry attempts
        FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
        backOffPolicy.setBackOffPeriod(2000); // 2 seconds will be the time to wait between retries (in milliseconds)
        RetryTemplate retryTemplate = new RetryTemplate();
        retryTemplate.setRetryPolicy(retryPolicy);
        retryTemplate.setBackOffPolicy(backOffPolicy);
        return retryTemplate;
    }
}

