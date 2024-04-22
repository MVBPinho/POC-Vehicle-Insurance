package com.pinho.vehicle.insurance.utils;

import com.pinho.vehicle.insurance.entities.TypeInsurance;

import java.util.List;

public class CalculatorTypeInsuranceVehicle {
    private final InsuranceCalculation insuranceCalculation;

    public CalculatorTypeInsuranceVehicle() {
        this.insuranceCalculation = new InsuranceCalculation();
    }

    public List<TypeInsurance> calculateInsurance(Double vehicleValue, Integer age, String location) {
        return insuranceCalculation.calculateTypeInsuranceVehicle(vehicleValue, age, location);
    }
}