package com.pinho.vehicle.insurance.unittests.services;

import com.pinho.vehicle.insurance.dto.CustomerDTO;
import com.pinho.vehicle.insurance.dto.TypeInsuranceCustomerDTO;
import com.pinho.vehicle.insurance.entities.Customer;
import com.pinho.vehicle.insurance.exceptions.RequiredObjectIsNullException;
import com.pinho.vehicle.insurance.repositories.CustomerRepository;
import com.pinho.vehicle.insurance.services.CustomerService;
import com.pinho.vehicle.insurance.unittests.mapper.mockInsurance.MockCustomer;
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
public class CustomerServicesTests {


    MockCustomer input;

    @InjectMocks
    private CustomerService service;

    @Mock
    CustomerRepository repository;

    @BeforeEach
    void setUpMocks() throws Exception {
        input = new MockCustomer();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Order(1)
    void testFindById() {
        Customer entity = input.mockEntity(1);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        TypeInsuranceCustomerDTO result = service.findById(1L);

        assertNotNull(result);

        assertEquals("Name Test1", result.getName());
        assertTrue(!result.getInsurances().isEmpty());
    }

    @Test
    @Order(2)
    void testCreate() {
        Customer entity = input.mockEntity(1);
        entity.setId(1L);

        Customer persisted = entity;
        persisted.setId(1L);

        CustomerDTO dto = input.mockCustomerDTO(1);
        dto.setId(1L);

        when(repository.save(entity)).thenReturn(persisted);

        TypeInsuranceCustomerDTO result = service.create(dto);

        assertNotNull(result);

        assertEquals("Name Test1", result.getName());
        assertTrue(!result.getInsurances().isEmpty());
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
        Customer entity = input.mockEntity(1);

        Customer persisted = entity;
        persisted.setId(1L);

        CustomerDTO dto = input.mockCustomerDTO(1);
        dto.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(entity)).thenReturn(persisted);

        var result = service.update(dto);

        assertNotNull(result);
        assertNotNull(result.getId());

        assertEquals(1L, (long) result.getId());
        assertEquals("Name Test1", result.getName());
        assertEquals("Location Test1", result.getLocation());
        assertEquals(26, result.getAge());
        assertEquals("123.451.789-11", result.getCpf());
        assertEquals(20000, result.getValueVehicle());
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
        Customer entity = input.mockEntity(1);
        entity.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        service.delete(1L);
    }

    @Test
    @Order(7)
    void testFindAll() {
        List<Customer> list = input.mockEntityList();

        when(repository.findAll()).thenReturn(list);

        var customers = service.findAll();

        assertNotNull(customers);
        assertEquals(9, customers.size());

        var customerTwo = customers.get(1);

        assertNotNull(customerTwo);
        assertNotNull(customerTwo.getId());

        assertEquals(2L, (long) customerTwo.getId());
        assertEquals("Name Test2", customerTwo.getName());
        assertEquals("Location Test2", customerTwo.getLocation());
        assertEquals(27, customerTwo.getAge());
        assertEquals("223.452.789-12", customerTwo.getCpf());
        assertEquals(40000, customerTwo.getValueVehicle());


        var insuranceEight = customers.get(7);

        assertNotNull(insuranceEight);
        assertNotNull(insuranceEight.getId());

        assertEquals(8L, (long) insuranceEight.getId());
        assertEquals("Name Test8", insuranceEight.getName());
        assertEquals("Location Test8", insuranceEight.getLocation());
        assertEquals(33, insuranceEight.getAge());
        assertEquals("823.458.789-18", insuranceEight.getCpf());
        assertEquals(160000, insuranceEight.getValueVehicle());


        var insurancetTree = customers.get(2);

        assertNotNull(insurancetTree);
        assertNotNull(insurancetTree.getId());

        assertEquals(3L, (long) insurancetTree.getId());
        assertEquals("Name Test3", insurancetTree.getName());
        assertEquals("Location Test3", insurancetTree.getLocation());
        assertEquals(28, insurancetTree.getAge());
        assertEquals("323.453.789-13", insurancetTree.getCpf());
        assertEquals(60000, insurancetTree.getValueVehicle());

    }

}
