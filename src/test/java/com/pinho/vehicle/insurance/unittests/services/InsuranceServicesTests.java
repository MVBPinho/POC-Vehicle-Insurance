package com.pinho.vehicle.insurance.unittests.services;


import com.pinho.vehicle.insurance.dto.InsuranceDTO;
import com.pinho.vehicle.insurance.entities.Insurance;
import com.pinho.vehicle.insurance.exceptions.RequiredObjectIsNullException;
import com.pinho.vehicle.insurance.repositories.InsuranceRepository;
import com.pinho.vehicle.insurance.services.InsuranceService;
import com.pinho.vehicle.insurance.unittests.mapper.mocks.MockInsurance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class InsuranceServicesTests {

    MockInsurance input;

    @InjectMocks
    private InsuranceService service;

    @Mock
    InsuranceRepository repository;

    @BeforeEach
    void setUpMocks() throws Exception {
        input = new MockInsurance();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Order(1)
    void testFindById() {
        Insurance entity = input.mockEntity(1);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        var result = service.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getId());

        assertEquals(1L, (long) result.getId());
        assertEquals("Type 1", result.getType());
        assertEquals(1, result.getCost());
    }

    @Test
    @Order(2)
    void testCreate() {
        Insurance entity = input.mockEntity(1);
        entity.setId(1L);

        Insurance persisted = entity;
        persisted.setId(1L);

        InsuranceDTO dto = input.mockDTO(1);
        dto.setId(1L);

        when(repository.save(entity)).thenReturn(persisted);

        var result = service.create(dto);

        assertNotNull(result);
        assertNotNull(result.getId());

        assertEquals(1L, (long) result.getId());
        assertEquals("Type 1", result.getType());
        assertEquals(1, result.getCost());
    }

    @Test
    @Order(3)
    void testCreateWithNullBook() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.create(null);
        });

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @Order(4)
    void testUpdate() {
        Insurance entity = input.mockEntity(1);

        Insurance persisted = entity;
        persisted.setId(1L);

        InsuranceDTO dto = input.mockDTO(1);
        dto.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(entity)).thenReturn(persisted);

        var result = service.update(dto);

        assertNotNull(result);
        assertNotNull(result.getId());

        assertEquals(1L, (long) result.getId());
        assertEquals("Type 1", result.getType());
        assertEquals(1, result.getCost());
    }

    @Test
    @Order(5)
    void testUpdateWithNullBook() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.update(null);
        });

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @Order(6)
    void testDelete() {
        Insurance entity = input.mockEntity(1);
        entity.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        service.delete(1L);
    }

    @Test
    @Order(7)
    void testFindAll() {
        List<Insurance> list = input.mockEntityList();

        when(repository.findAll()).thenReturn(list);

        var insurances = service.findAll();

        assertNotNull(insurances);
        assertEquals(9, insurances.size());

        var insuranceOne = insurances.get(0);

        assertNotNull(insuranceOne);
        assertNotNull(insuranceOne.getId());

        assertEquals(1L, (long) insuranceOne.getId());
        assertEquals("Type 1", insuranceOne.getType());
        assertEquals(1, insuranceOne.getCost());

        var insuranceFour = insurances.get(3);

        assertNotNull(insuranceFour);
        assertNotNull(insuranceFour.getId());

        assertEquals(4L, (long) insuranceFour.getId());
        assertEquals("Type 4", insuranceFour.getType());
        assertEquals(4, insuranceFour.getCost());

        var insuranceSeven = insurances.get(6);

        assertNotNull(insuranceSeven);
        assertNotNull(insuranceSeven.getId());

        assertEquals(7L, (long) insuranceSeven.getId());
        assertEquals("Type 7", insuranceSeven.getType());
        assertEquals(7, insuranceSeven.getCost());
    }
}