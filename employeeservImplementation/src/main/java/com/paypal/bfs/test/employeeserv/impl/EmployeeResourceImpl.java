package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Baseresponse;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.exceptions.BaseException;
import com.paypal.bfs.test.employeeserv.services.employeecontrollerservice.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;

import static com.paypal.bfs.test.employeeserv.constants.PaypalConstants.INTERNAL_SERVER_ERROR;
import static com.paypal.bfs.test.employeeserv.constants.PaypalConstants.WRONG_PARAMETERS;


/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeResourceImpl.class);

    @Autowired
    private EmployeeService employeeService;

    @Override
    public ResponseEntity<Baseresponse> employeeGetById(Long id) {
        try {
            Employee employee = employeeService.getEmployeeByEmployeeId(id);
            return ResponseEntity.status(HttpStatus.OK).body(employee);
        } catch (BaseException e) {
            LOGGER.error("Exception occured during employeeGetById {}", e.getMessage());
            Baseresponse baseresponse = new Baseresponse();
            baseresponse.setErrorCode(e.getErrorCode());
            baseresponse.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(baseresponse);
        } catch (Exception e) {
            LOGGER.error("Exception occured during employeeGetById {}", e.getMessage());
            Baseresponse baseresponse = new Baseresponse();
            baseresponse.setErrorCode(500);
            baseresponse.setMessage(INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(baseresponse);
        }
    }

    @Override
    public ResponseEntity<Baseresponse> createEmployee(Employee employee) {
        try {
            employeeService.createEmployee(employee);
            Baseresponse baseresponse = new Baseresponse();
            baseresponse.setErrorCode(200);
            return ResponseEntity.status(HttpStatus.OK).body(baseresponse);
        } catch (BaseException e) {
            LOGGER.error("Exception occured during createEmployee {}", e.getMessage());
            Baseresponse baseresponse = new Baseresponse();
            baseresponse.setErrorCode(e.getErrorCode());
            baseresponse.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(baseresponse);
        } catch (ConstraintViolationException e) {
            LOGGER.error("Exception occured during createEmployee {}", e.getMessage());
            Baseresponse baseresponse = new Baseresponse();
            baseresponse.setErrorCode(400);
            baseresponse.setMessage(WRONG_PARAMETERS);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(baseresponse);
        } catch (Exception e) {
            LOGGER.error("Exception occured during createEmployee {}", e.getMessage());
            Baseresponse baseresponse = new Baseresponse();
            baseresponse.setErrorCode(500);
            baseresponse.setMessage(INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(baseresponse);
        }
    }
}
