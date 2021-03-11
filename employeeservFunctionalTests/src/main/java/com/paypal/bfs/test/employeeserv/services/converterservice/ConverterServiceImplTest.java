package com.paypal.bfs.test.employeeserv.services.converterservice;


import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.entities.AddressEntity;
import com.paypal.bfs.test.employeeserv.entities.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.services.converterservice.impl.ConverterServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class ConverterServiceImplTest {

    @InjectMocks
    private ConverterServiceImpl converterService;

    @Test
    public void convertEmployeeEntityToEmployeeObjectTestNull() {
        System.out.println(converterService.convertEmployeeEntityToEmployeeObject(null));
    }

    @Test
    public void convertEmployeeEntityToEmployeeObjectTestNonNull() {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setAddress(new AddressEntity());
        System.out.println(converterService.convertEmployeeEntityToEmployeeObject(employeeEntity));
    }

    @Test
    public void convertEmployeeObjectToEmployeeEntityTestNull() {
        System.out.println(converterService.convertEmployeeObjectToEmployeeEntity(null));
    }

    @Test
    public void convertEmployeeObjectToEmployeeEntityTestNonNull() {
        Employee employee = new Employee();
        employee.setAddress(new Address());
        System.out.println(converterService.convertEmployeeObjectToEmployeeEntity(employee));
    }
}
