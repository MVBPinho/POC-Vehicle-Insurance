package com.pinho.vehicle.insurance.unittests.mapper.mocks;

import com.pinho.vehicle.insurance.dto.CostTypeInsuranceDTO;
import com.pinho.vehicle.insurance.dto.InsuranceDTO;
import com.pinho.vehicle.insurance.entities.Insurance;

import java.util.ArrayList;
import java.util.List;

public class MockInsurance {

    public Insurance mockEntity() {
        return mockEntity(0);
    }

    public InsuranceDTO mockDTO() {
        return mockDTO(0);
    }

    public CostTypeInsuranceDTO mockCostTypeInsuranceDTO() {
        return mockCostTypeInsuranceDTO(0);
    }

    public List<Insurance> mockEntityList() {
        List<Insurance> insurances = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            insurances.add(mockEntity(i));
        }
        return insurances;
    }

    public List<InsuranceDTO> mockDTOList() {
        List<InsuranceDTO> insurances = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            insurances.add(mockDTO(i));
        }
        return insurances;
    }

    public List<CostTypeInsuranceDTO> mockCostTypeInsuranceDTOList() {
        List<CostTypeInsuranceDTO> insurancesDto = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            insurancesDto.add(mockCostTypeInsuranceDTO(i));
        }
        return insurancesDto;
    }

    public Insurance mockEntity(Integer number) {
        Insurance insurance = new Insurance();
        insurance.setId(number.longValue());
        insurance.setType("Type " + number.longValue());
        insurance.setCost(number);
        return insurance;
    }

    public InsuranceDTO mockDTO(Integer number) {
        InsuranceDTO dto = new InsuranceDTO();
        dto.setId(number.longValue());
        dto.setType("Type " + number.longValue());
        dto.setCost(number);
        return dto;
    }

    public CostTypeInsuranceDTO mockCostTypeInsuranceDTO(Integer number) {
        CostTypeInsuranceDTO dto = new CostTypeInsuranceDTO();
        dto.setType("Type " + number.longValue());
        dto.setCost(number);
        return dto;
    }
}
