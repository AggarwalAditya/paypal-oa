package com.paypal.bfs.test.employeeserv.services.employeecontrollerservice;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.entities.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.enums.ValidatorKeys;
import com.paypal.bfs.test.employeeserv.repositories.EmployeeCustomDao;
import com.paypal.bfs.test.employeeserv.repositories.EmployeeDao;
import com.paypal.bfs.test.employeeserv.services.converterservice.ConverterService;
import com.paypal.bfs.test.employeeserv.services.employeecontrollerservice.impl.EmployeeServiceImpl;
import com.paypal.bfs.test.employeeserv.services.validator.Validator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RunWith(PowerMockRunner.class)
public class EmployeeServiceImplTest {

    @Mock
    private EmployeeDao employeeDao;

    @Mock
    private EmployeeCustomDao employeeCustomDao;

    @Mock
    private ConverterService converterService;

    @Mock
    private Validator validator;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    public void getEmployeeByEmployeeIdTestNull() {
        boolean isValid = true;
        try {
            employeeService.getEmployeeByEmployeeId(null);
        } catch (Exception e) {
            isValid = false;
        }
        Assert.assertEquals(false, isValid);
    }

    @Test
    public void getEmployeeByEmployeeIdTestNonNull() {
        boolean isValid = true;
        Long id = 1L;
        EmployeeEntity employeeEntity = new EmployeeEntity();

        try {
            PowerMockito.when(employeeDao.findById(id)).thenReturn(Optional.of(employeeEntity));
            PowerMockito.when(converterService.convertEmployeeEntityToEmployeeObject(employeeEntity)).thenReturn(new Employee());
            employeeService.getEmployeeByEmployeeId(id);
        } catch (Exception e) {
            isValid = false;
        }
        Assert.assertEquals(true, isValid);
    }

    @Test
    public void getEmployeeByEmployeeIdTestEntityDoesNotExist() {
        boolean isValid = true;
        Long id = 1L;
        EmployeeEntity employeeEntity = new EmployeeEntity();

        try {
            PowerMockito.when(employeeDao.findById(id)).thenReturn(Optional.ofNullable(null));
            PowerMockito.when(converterService.convertEmployeeEntityToEmployeeObject(employeeEntity)).thenReturn(new Employee());
            employeeService.getEmployeeByEmployeeId(id);
        } catch (Exception e) {
            isValid = false;
        }
        Assert.assertEquals(false, isValid);
    }

    @Test
    public void createEmployeeTestNull() {
        boolean isValid = true;
        try {
            employeeService.createEmployee(null);
        } catch (Exception e) {
            isValid = false;
        }
        Assert.assertEquals(false, isValid);
    }

    @Test
    public void createEmployeeTestEntityExists() {
        boolean isValid = true;
        Employee employee = new Employee();
        employee.setAddress(new Address());
        Map<String, String> validatorMap = new HashMap<>();
        validatorMap.put(ValidatorKeys.DATE_OF_BIRTH.name(),null);
        validatorMap.put(ValidatorKeys.EMAIL.name(),null);
        validatorMap.put(ValidatorKeys.ZIPCODE.name(),null);
        try {
            PowerMockito.when(validator.isValidString(validatorMap)).thenReturn(null);
            PowerMockito.when(employeeCustomDao.getEmployeeByEmail(employee)).thenReturn(new EmployeeEntity());
            employeeService.createEmployee(employee);
        } catch (Exception e) {
            isValid = false;
        }
        Assert.assertEquals(false, isValid);
    }

    @Test
    public void createEmployeeTestEntityDoesNotExists() {
        boolean isValid = true;
        Employee employee = new Employee();
        employee.setAddress(new Address());
        EmployeeEntity employeeEntity = new EmployeeEntity();
        Map<String, String> validatorMap = new HashMap<>();
        validatorMap.put(ValidatorKeys.DATE_OF_BIRTH.name(),null);
        validatorMap.put(ValidatorKeys.EMAIL.name(),null);
        validatorMap.put(ValidatorKeys.ZIPCODE.name(),null);
        try {
            PowerMockito.when(validator.isValidString(validatorMap)).thenReturn(null);
            PowerMockito.when(employeeCustomDao.getEmployeeByEmail(employee)).thenReturn(null);
            PowerMockito.when(converterService.convertEmployeeObjectToEmployeeEntity(employee)).thenReturn(employeeEntity);
            employeeService.createEmployee(employee);
        } catch (Exception e) {
            isValid = false;
        }
        Assert.assertEquals(true, isValid);
    }

}
