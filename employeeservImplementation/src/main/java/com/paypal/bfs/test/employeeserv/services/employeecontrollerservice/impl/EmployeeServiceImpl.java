package com.paypal.bfs.test.employeeserv.services.employeecontrollerservice.impl;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.entities.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.exceptions.BaseException;
import com.paypal.bfs.test.employeeserv.repositories.EmployeeCustomDao;
import com.paypal.bfs.test.employeeserv.repositories.EmployeeDao;
import com.paypal.bfs.test.employeeserv.services.converterservice.ConverterService;
import com.paypal.bfs.test.employeeserv.services.employeecontrollerservice.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

import static com.paypal.bfs.test.employeeserv.constants.PaypalConstants.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private EmployeeCustomDao employeeCustomDao;

    @Autowired
    private ConverterService converterService;

    @Override
    public Employee getEmployeeByEmployeeId(Long id) throws Exception {
        LOGGER.info("Request received to get employee with id {}", id);
        Employee employee = null;

        if (isValidGetEmployeeByIdRequest(id)) {
            Optional<EmployeeEntity> employeeEntityOptional = employeeDao.findById(id);
            if (!employeeEntityOptional.isPresent()) {
                LOGGER.info("No employee with id {} exists", id);
                throw new BaseException(EMPLOYEE_DOES_NOT_EXIST, 400);
            }
            EmployeeEntity employeeEntity = employeeEntityOptional.get();
            employee = converterService.convertEmployeeEntityToEmployeeObject(employeeEntity);
        }
        LOGGER.info("Returning employee: {}", employee);
        return employee;
    }

    @Override
    public boolean createEmployee(Employee employee) throws Exception {
        LOGGER.info("Request to create employee {}", employee);
        if (isValidCreateEmployeeRequest(employee)) {
            EmployeeEntity employeeEntity = converterService.convertEmployeeObjectToEmployeeEntity(employee);
            employeeDao.save(employeeEntity);
        }
        LOGGER.info("employee created");
        return true;
    }

    private boolean isValidGetEmployeeByIdRequest(Long id) throws BaseException {
        if (Objects.isNull(id)) {
            LOGGER.info("Id is missing from request");
            throw new BaseException(MANDATORY_PARAMS_MISSING, 400);
        }

        return true;
    }

    private boolean isValidCreateEmployeeRequest(Employee employee) throws BaseException {
        if (Objects.isNull(employee) || Objects.isNull(employee.getAddress())) {
            throw new BaseException(MANDATORY_PARAMS_MISSING, 400);
        }

        Object existingEntity = employeeCustomDao.getEmployeeByEmail(employee);
        if (Objects.nonNull(existingEntity)) {
            throw new BaseException(EMPLOYEE_ENTITY_EXISTS, 400);
        }
        return true;
    }
}
