package com.sobhy.system.irrigationsystem.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IrrigationPredictionService {

//    private final Map<String, Double> cropWaterRequirementMap = new HashMap<>();
//    private final Map<String, Double> cropIrrigationTimeMap = new HashMap<>();
//
//    public IrrigationPredictionService() {
//        // Predefined data for water requirement (in liters per hour) and irrigation time (in minutes per square meter)
//        cropWaterRequirementMap.put("Tomato", 4.0);
//        cropWaterRequirementMap.put("Potato", 3.5);
//        cropWaterRequirementMap.put("Lettuce", 3.0);
//        // Add more crops as needed
//
//        cropIrrigationTimeMap.put("Tomato", 2.0);
//        cropIrrigationTimeMap.put("Potato", 2.5);
//        cropIrrigationTimeMap.put("Lettuce", 2.2);
//        // Add more crops as needed
//    }
//
//    public double predictWaterRequirement(String crop) {
//        // If the crop is not found in the map, return a default value of 2.0 liters per hour
//        return cropWaterRequirementMap.getOrDefault(crop, 2.0);
//    }
//
//    public double predictIrrigationTime(String crop, double cultivatedArea) {
//        // If the crop is not found in the map, return a default value of 2.0 minutes per square meter
//        return cropIrrigationTimeMap.getOrDefault(crop, 2.0) * cultivatedArea;
//    }
}
