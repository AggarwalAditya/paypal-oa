package com.paypal.bfs.test.employeeserv.repositories;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

public interface EmployeeCustomDao {

    public Object getEmployeeByEmail(Employee employee);
}
