package com.pinho.vehicle.insurance.utils;

import com.pinho.vehicle.insurance.entities.TypeInsurance;

import java.util.ArrayList;
import java.util.List;

public class InsuranceCalculation {
    public List<TypeInsurance> calculateTypeInsuranceVehicle(Double vehicleValue, Integer age, String location) {
        String insuranceBasic = "basic";
        String insurancePartial = "partial";
        String insuranceTotal = "total";

        List<TypeInsurance> insurances = new ArrayList<>();
        boolean isYoung = age < 30;
        boolean isSP = location.equalsIgnoreCase("SP");

        if (vehicleValue <= 70000) {
            if (isYoung && isSP) {
                insurances.add(new TypeInsurance(insurancePartial, 3));
            } else {
                insurances.add(new TypeInsurance(insuranceBasic, 2));
            }
        } else if (vehicleValue > 70000 && vehicleValue < 100000) {
            if (isSP) {
                insurances.add(new TypeInsurance(insurancePartial, 3));
            } else {
                insurances.add(new TypeInsurance(insuranceBasic, 2));
            }
        } else {
            if (isYoung && isSP) {
                insurances.add(new TypeInsurance(insuranceTotal, 4));
            } else if (isYoung) {
                insurances.add(new TypeInsurance(insurancePartial, 3));
            } else {
                insurances.add(new TypeInsurance(insuranceBasic, 2));
            }
        }
        return insurances;
    }
}