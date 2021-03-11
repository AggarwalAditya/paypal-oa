package com.paypal.bfs.test.employeeserv.services.converterservice.impl;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.entities.AddressEntity;
import com.paypal.bfs.test.employeeserv.entities.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.services.converterservice.ConverterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ConverterServiceImpl implements ConverterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConverterServiceImpl.class);

    /**
     * Convert employee entity to employee object
     * @param employeeEntity
     * @return
     */
    @Override
    public Employee convertEmployeeEntityToEmployeeObject(EmployeeEntity employeeEntity) {
        LOGGER.info("Converting employee entity to employee object");
        Employee employee = null;
        if (Objects.nonNull(employeeEntity)) {
            LOGGER.info("Employee Entity id : {}", employeeEntity.getId());
            employee = new Employee();
            employee.setId(employeeEntity.getId());
            employee.setFirstName(employeeEntity.getFirstName());
            employee.setLastName(employeeEntity.getLastName());
            employee.setDateOfBirth(employeeEntity.getDateOfBirth());
            employee.setEmail(employeeEntity.getEmail());
            if(Objects.nonNull(employeeEntity.getAddress())) {
                AddressEntity addressEntity = employeeEntity.getAddress();
                Address address = new Address();
                address.setLine1(addressEntity.getLine1());
                address.setLine2(addressEntity.getLine2());
                address.setCity(addressEntity.getCity());
                address.setState(addressEntity.getState());
                address.setCountry(addressEntity.getCountry());
                address.setZipcode(addressEntity.getZipcode());
                employee.setAddress(address);
            }
        }
        return employee;
    }

    /**
     * convert employee object to employee entity
     * @param employee
     * @return
     */
    @Override
    public EmployeeEntity convertEmployeeObjectToEmployeeEntity(Employee employee) {
        EmployeeEntity employeeEntity = null;
        if (Objects.nonNull(employee)) {
            employeeEntity = new EmployeeEntity();
            employeeEntity.setFirstName(employee.getFirstName());
            employeeEntity.setLastName(employee.getLastName());
            employeeEntity.setEmail(employee.getEmail());
            employeeEntity.setDateOfBirth(employee.getDateOfBirth());
            employeeEntity.setStatus(1);
            if(Objects.nonNull(employee.getAddress())) {
                AddressEntity addressEntity = new AddressEntity();
                addressEntity.setLine1(employee.getAddress().getLine1());
                addressEntity.setLine2(employee.getAddress().getLine2());
                addressEntity.setCity(employee.getAddress().getCity());
                addressEntity.setState(employee.getAddress().getState());
                addressEntity.setCountry(employee.getAddress().getCountry());
                addressEntity.setZipcode(employee.getAddress().getZipcode());
                addressEntity.setStatus(1);
                employeeEntity.setAddress(addressEntity);
            }
        }
        return employeeEntity;
    }

}
