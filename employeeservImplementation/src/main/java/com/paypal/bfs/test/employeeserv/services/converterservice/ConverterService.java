package com.paypal.bfs.test.employeeserv.services.converterservice;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.entities.EmployeeEntity;

public interface ConverterService {

    public Employee convertEmployeeEntityToEmployeeObject(EmployeeEntity employeeEntity);

    public EmployeeEntity convertEmployeeObjectToEmployeeEntity(Employee employee);
}
