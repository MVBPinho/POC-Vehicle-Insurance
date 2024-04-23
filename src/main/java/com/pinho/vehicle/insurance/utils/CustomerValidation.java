package com.pinho.vehicle.insurance.utils;

import java.util.Arrays;
import java.util.List;

public class CustomerValidation {

    private boolean isValidCpf(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.isEmpty() || cpf.length() < 11) {
            return false;
        }

        int sum = 0;
        int multiplier = 10;
        for (int i = 0; i < 9; i++) {
            sum += Integer.parseInt(cpf.substring(i, i + 1)) * multiplier--;
        }
        int expectedCheckDigit1 = (sum * 10) % 11;
        if (expectedCheckDigit1 == 10 || expectedCheckDigit1 == 11) {
            expectedCheckDigit1 = 0;
        }

        sum = 0;
        multiplier = 11;
        for (int i = 0; i < 10; i++) {
            sum += Integer.parseInt(cpf.substring(i, i + 1)) * multiplier--;
        }
        int expectedCheckDigit2 = (sum * 10) % 11;
        if (expectedCheckDigit2 == 10 || expectedCheckDigit2 == 11) {
            expectedCheckDigit2 = 0;
        }

        return expectedCheckDigit1 == Integer.parseInt(cpf.substring(9, 10))
                && expectedCheckDigit2 == Integer.parseInt(cpf.substring(10, 11));
    }

    private static boolean isValidLocation(String location) {
        List<String> validLocations = Arrays.asList("AC", "AL", "AP", "AM", "BA", "CE",
                "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI",
                "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO");
        return validLocations.contains(location.toUpperCase());
    }
}