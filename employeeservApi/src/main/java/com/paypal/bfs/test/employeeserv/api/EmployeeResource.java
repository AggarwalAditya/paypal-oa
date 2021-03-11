package com.paypal.bfs.test.employeeserv.api;

import com.paypal.bfs.test.employeeserv.api.model.Baseresponse;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Interface for employee resource operations.
 */
public interface EmployeeResource {

    /**
     * Retrieves the {@link Employee} resource by id.
     *
     * @param id employee id.
     * @return {@link Employee} resource.
     */
    @RequestMapping("/v1/bfs/employees/{id}")
    ResponseEntity<Baseresponse> employeeGetById(@PathVariable("id") Long id);

    /**
     * Creates employee with new data provided
     *
     * @param employee
     * @return
     */
    @RequestMapping(value = "/v1/bfs/employees/create", method = RequestMethod.POST)
    ResponseEntity<Baseresponse> createEmployee(@RequestBody Employee employee);

}
