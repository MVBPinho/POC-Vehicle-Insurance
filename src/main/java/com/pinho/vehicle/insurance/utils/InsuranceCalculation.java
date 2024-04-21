package com.pinho.vehicle.insurance.utils;

import com.pinho.vehicle.insurance.entities.Customer;
import com.pinho.vehicle.insurance.entities.Insurance;

import java.util.ArrayList;
import java.util.List;

public class InsuranceCalculation {
    public List<Insurance> calculateTypeInsuranceVehicle(Customer customer) {
        String insuranceBasic = "basic";
        String insurancePartial = "partial";
        String insuranceTotal = "total";

        List<Insurance> insurances = new ArrayList<>();
        double vehicleValue = customer.getValueVehicle();
        boolean isYoung = customer.getAge() < 30;
        boolean isSP = customer.getLocation().equalsIgnoreCase("SP");

        if (vehicleValue <= 70000) {
            if (isYoung && isSP) {
                insurances.add(new Insurance(insurancePartial, 3, null));
            } else {
                insurances.add(new Insurance(insuranceBasic, 2, null));
            }
        } else if (vehicleValue > 70000 && vehicleValue < 100000) {
            if (isSP) {
                insurances.add(new Insurance(insurancePartial, 3, null));
            } else {
                insurances.add(new Insurance(insuranceBasic, 2, null));
            }
        } else {
            if (isYoung && isSP) {
                insurances.add(new Insurance(insuranceTotal, 4, null));
            } else if (isYoung) {
                insurances.add(new Insurance(insurancePartial, 3, null));
            } else {
                insurances.add(new Insurance(insuranceBasic, 2, null));
            }
        }
        return insurances;
    }
}