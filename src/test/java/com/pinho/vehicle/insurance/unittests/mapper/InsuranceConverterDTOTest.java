package com.pinho.vehicle.insurance.unittests.mapper;

import com.pinho.vehicle.insurance.dto.InsuranceDTO;
import com.pinho.vehicle.insurance.entities.Insurance;
import com.pinho.vehicle.insurance.unittests.mapper.mocks.MockInsurance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InsuranceConverterDTOTest {

    MockInsurance input;

    @BeforeEach
    public void setUp() {
        input = new MockInsurance();
    }

    @Test
    @Order(1)
    public void parseEntityToDTOTest() {

        Insurance entity = input.mockEntity(1);
        InsuranceDTO dto = toMapInsuranceDTO(entity);

        assertNotNull(dto);
        assertNotNull(dto.getId());

        assertEquals(1L, (long) dto.getId());
        assertEquals("Type 1", dto.getType());
        assertEquals(1, dto.getCost());
    }

    @Test
    @Order(2)
    public void parseEntityListToDTOListTest() {

        List<Insurance> listEntity = input.mockEntityList();

        InsuranceDTO dtoOne = toMapInsuranceDTO(listEntity.get(0));

        assertEquals(1L, (long) dtoOne.getId());
        assertEquals("Type 1", dtoOne.getType());
        assertEquals(1, dtoOne.getCost());

        InsuranceDTO dtoTwo = toMapInsuranceDTO(listEntity.get(1));

        assertEquals(2L, (long) dtoTwo.getId());
        assertEquals("Type 2", dtoTwo.getType());
        assertEquals(2, dtoTwo.getCost());

        InsuranceDTO dtoFour = toMapInsuranceDTO(listEntity.get(3));

        assertEquals(4L, (long) dtoFour.getId());
        assertEquals("Type 4", dtoFour.getType());
        assertEquals(4, dtoFour.getCost());
    }


    @Test
    @Order(3)
    public void parseDTOtoEntityTest() {

        InsuranceDTO dto = input.mockDTO(1);
        Insurance entity = toMapInsurance(dto);

        assertNotNull(dto);
        assertNotNull(dto.getId());

        assertEquals(1L, (long) entity.getId());
        assertEquals("Type 1", entity.getType());
        assertEquals(1, entity.getCost());
    }

    @Test
    @Order(4)
    public void parseDTOListToEntityListTest() {

        List<InsuranceDTO> dto = input.mockDTOList();

        Insurance entityTwo = toMapInsurance(dto.get(1));

        assertEquals(2L, (long) entityTwo.getId());
        assertEquals("Type 2", entityTwo.getType());
        assertEquals(2, entityTwo.getCost());

        Insurance entityNine = toMapInsurance(dto.get(8));

        assertEquals(9L, (long) entityNine.getId());
        assertEquals("Type 9", entityNine.getType());
        assertEquals(9, entityNine.getCost());

        Insurance entitySeven = toMapInsurance(dto.get(6));

        assertEquals(7L, (long) entitySeven.getId());
        assertEquals("Type 7", entitySeven.getType());
        assertEquals(7, entitySeven.getCost());
    }

    public InsuranceDTO toMapInsuranceDTO(Insurance insurance) {
        return new InsuranceDTO(
                insurance.getId(),
                insurance.getType(),
                insurance.getCost()
        );
    }

    public Insurance toMapInsurance(InsuranceDTO insurance) {
        return new Insurance(
                insurance.getId(),
                insurance.getType(),
                insurance.getCost()
        );
    }

}
