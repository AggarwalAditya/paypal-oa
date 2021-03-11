package com.paypal.bfs.test.employeeserv.services.employeecontrollerservice;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

public interface EmployeeService {

    public Employee getEmployeeByEmployeeId(Long id) throws Exception;

    public boolean createEmployee(Employee employee) throws Exception;
}
