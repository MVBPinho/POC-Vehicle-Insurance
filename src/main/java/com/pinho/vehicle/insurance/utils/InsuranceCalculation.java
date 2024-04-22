package com.pinho.vehicle.insurance.utils;

import com.pinho.vehicle.insurance.entities.Customer;
import com.pinho.vehicle.insurance.entities.Insurance;

import java.util.ArrayList;
import java.util.List;

public class InsuranceCalculation {
    public List<Insurance> calculateTypeInsuranceVehicle(Double vehicleValue, Integer age, String location) {
        String insuranceBasic = "basic";
        String insurancePartial = "partial";
        String insuranceTotal = "total";

        List<Insurance> insurances = new ArrayList<>();
        boolean isYoung = age < 30;
        boolean isSP = location.equalsIgnoreCase("SP");

        if (vehicleValue <= 70000) {
            if (isYoung && isSP) {
                insurances.add(new Insurance(insurancePartial, 3));
            } else {
                insurances.add(new Insurance(insuranceBasic, 2));
            }
        } else if (vehicleValue > 70000 && vehicleValue < 100000) {
            if (isSP) {
                insurances.add(new Insurance(insurancePartial, 3));
            } else {
                insurances.add(new Insurance(insuranceBasic, 2));
            }
        } else {
            if (isYoung && isSP) {
                insurances.add(new Insurance(insuranceTotal, 4));
            } else if (isYoung) {
                insurances.add(new Insurance(insurancePartial, 3));
            } else {
                insurances.add(new Insurance(insuranceBasic, 2));
            }
        }
        return insurances;
    }
}