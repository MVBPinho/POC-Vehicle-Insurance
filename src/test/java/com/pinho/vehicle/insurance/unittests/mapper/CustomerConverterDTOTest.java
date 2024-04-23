package com.pinho.vehicle.insurance.unittests.mapper;

import com.pinho.vehicle.insurance.dto.CostTypeInsuranceDTO;
import com.pinho.vehicle.insurance.dto.CustomerDTO;
import com.pinho.vehicle.insurance.dto.TypeInsuranceCustomerDTO;
import com.pinho.vehicle.insurance.entities.Customer;
import com.pinho.vehicle.insurance.unittests.mapper.mocks.MockCustomer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerConverterDTOTest {

    MockCustomer input;

    @BeforeEach
    public void setUp() {
        input = new MockCustomer();
    }

    @Test
    @Order(1)
    public void parseEntityToDTOTest() {

        Customer entity = input.mockEntity(1);
        CustomerDTO dto = toMapCustomerDTO(entity);

        assertNotNull(dto);
        assertNotNull(dto.getId());

        assertEquals(1L, (long) entity.getId());
        assertEquals("Name Test1", entity.getName());
        assertEquals("Location Test1", entity.getLocation());
        assertEquals(26, entity.getAge());
        assertEquals("123.451.789-11", entity.getCpf());
        assertEquals(20000, entity.getValueVehicle());
    }

    @Test
    @Order(2)
    public void parseEntityListToDTOListTest() {

        List<Customer> listEntity = input.mockEntityList();

        CustomerDTO dtoOne = toMapCustomerDTO(listEntity.get(0));

        assertEquals(1L, (long) dtoOne.getId());
        assertEquals("Name Test1", dtoOne.getName());
        assertEquals("Location Test1", dtoOne.getLocation());
        assertEquals(26, dtoOne.getAge());
        assertEquals("123.451.789-11", dtoOne.getCpf());
        assertEquals(20000, dtoOne.getValueVehicle());


        CustomerDTO dtoTwo = toMapCustomerDTO(listEntity.get(1));

        assertEquals(2, (long) dtoTwo.getId());
        assertEquals("Name Test2", dtoTwo.getName());
        assertEquals("Location Test2", dtoTwo.getLocation());
        assertEquals(27, dtoTwo.getAge());
        assertEquals("223.452.789-12", dtoTwo.getCpf());
        assertEquals(40000, dtoTwo.getValueVehicle());


        CustomerDTO dtoFour = toMapCustomerDTO(listEntity.get(3));

        assertEquals(4L, (long) dtoFour.getId());
        assertEquals("Name Test4", dtoFour.getName());
        assertEquals("Location Test4", dtoFour.getLocation());
        assertEquals(29, dtoFour.getAge());
        assertEquals("423.454.789-14", dtoFour.getCpf());
        assertEquals(80000, dtoFour.getValueVehicle());
    }


    @Test
    @Order(3)
    public void parseEntityToCustomerTypeInsuranceCustomerDTOTest() {

        Customer entity = input.mockEntity(1);
        TypeInsuranceCustomerDTO dto = toMapCustomerTypeInsuranceCustomerDTO(entity);

        assertNotNull(dto);

        assertEquals("Name Test1", entity.getName());
        assertFalse(entity.getInsurances().isEmpty());
        assertEquals("basic", entity.getInsurances().get(0).getType());
        assertEquals(2, entity.getInsurances().get(0).getCost());
    }

    @Test
    @Order(4)
    public void parseEntityListToCustomerTypeInsuranceCustomerDTOListTest() {

        List<Customer> listEntity = input.mockEntityList();

        TypeInsuranceCustomerDTO dtoThree = toMapCustomerTypeInsuranceCustomerDTO(listEntity.get(2));

        assertEquals("Name Test3", dtoThree.getName());
        assertFalse(dtoThree.getInsurances().isEmpty());
        assertEquals("basic", dtoThree.getInsurances().get(0).getType());
        assertEquals(2, dtoThree.getInsurances().get(0).getCost());

        TypeInsuranceCustomerDTO dtoTwo = toMapCustomerTypeInsuranceCustomerDTO(listEntity.get(1));

        assertEquals("Name Test2", dtoTwo.getName());
        assertFalse(dtoTwo.getInsurances().isEmpty());
        assertEquals("basic", dtoTwo.getInsurances().get(0).getType());
        assertEquals(2, dtoTwo.getInsurances().get(0).getCost());

        TypeInsuranceCustomerDTO dtoFour = toMapCustomerTypeInsuranceCustomerDTO(listEntity.get(3));

        assertEquals("Name Test4", dtoFour.getName());
        assertFalse(dtoFour.getInsurances().isEmpty());
        assertEquals("basic", dtoFour.getInsurances().get(0).getType());
        assertEquals(2, dtoFour.getInsurances().get(0).getCost());
    }

    @Test
    @Order(5)
    public void parseDTOToEntityTest() {

        CustomerDTO dto = input.mockCustomerDTO(1);
        Customer entity = toMapInsuranceEntity(dto);

        assertNotNull(entity);
        assertNotNull(entity.getId());

        assertEquals(1L, (long) entity.getId());
        assertEquals("Name Test1", entity.getName());
        assertEquals("Location Test1", entity.getLocation());
        assertEquals(26, entity.getAge());
        assertEquals("123.451.789-11", entity.getCpf());
        assertEquals(20000, entity.getValueVehicle());
    }

    @Test
    @Order(6)
    public void parseDTOListToEntityListTest() {

        List<CustomerDTO> listDTO = input.mockDTOList();

        Customer entityOne = toMapInsuranceEntity(listDTO.get(0));

        assertEquals(1L, (long) entityOne.getId());
        assertEquals("Name Test1", entityOne.getName());
        assertEquals("Location Test1", entityOne.getLocation());
        assertEquals(26, entityOne.getAge());
        assertEquals("123.451.789-11", entityOne.getCpf());
        assertEquals(20000, entityOne.getValueVehicle());


        Customer entityTwo = toMapInsuranceEntity(listDTO.get(1));

        assertEquals(2, (long) entityTwo.getId());
        assertEquals("Name Test2", entityTwo.getName());
        assertEquals("Location Test2", entityTwo.getLocation());
        assertEquals(27, entityTwo.getAge());
        assertEquals("223.452.789-12", entityTwo.getCpf());
        assertEquals(40000, entityTwo.getValueVehicle());


        Customer entityFour = toMapInsuranceEntity(listDTO.get(3));

        assertEquals(4L, (long) entityFour.getId());
        assertEquals("Name Test4", entityFour.getName());
        assertEquals("Location Test4", entityFour.getLocation());
        assertEquals(29, entityFour.getAge());
        assertEquals("423.454.789-14", entityFour.getCpf());
        assertEquals(80000, entityFour.getValueVehicle());
    }

    public Customer toMapInsuranceEntity(CustomerDTO customer) {
        return new Customer(
                customer.getId(),
                customer.getName(),
                customer.getCpf(),
                customer.getAge(),
                customer.getLocation(),
                customer.getValueVehicle()
        );
    }

    private CustomerDTO toMapCustomerDTO(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getCpf(),
                customer.getAge(),
                customer.getLocation(),
                customer.getValueVehicle()
        );
    }


    private TypeInsuranceCustomerDTO toMapCustomerTypeInsuranceCustomerDTO(Customer customer) {
        if (customer == null) {
            return null;
        }
        List<CostTypeInsuranceDTO> customersDTO = customer.getInsurances()
                .stream()
                .map(insurance -> new CostTypeInsuranceDTO(insurance.getType(), insurance.getCost()))
                .collect(Collectors.toList());
        return new TypeInsuranceCustomerDTO(customer.getName(), customersDTO);
    }
}
