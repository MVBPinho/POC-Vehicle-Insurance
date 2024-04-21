package com.pinho.vehicle.insurance.utils;

import com.pinho.vehicle.insurance.entities.Customer;
import com.pinho.vehicle.insurance.entities.Insurance;

import java.util.List;

public class CalculatorTypeInsuranceVehicle {
    private final InsuranceCalculation insuranceCalculation;

    public CalculatorTypeInsuranceVehicle() {
        this.insuranceCalculation = new InsuranceCalculation();
    }

    public List<Insurance> calculateInsurance(Customer customer) {
        return insuranceCalculation.calculateTypeInsuranceVehicle(customer);
    }
}