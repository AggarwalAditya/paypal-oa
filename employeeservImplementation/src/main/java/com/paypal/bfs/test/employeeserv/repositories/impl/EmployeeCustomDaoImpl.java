package com.paypal.bfs.test.employeeserv.repositories.impl;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.repositories.EmployeeCustomDao;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

/**
 * Custom DAO for custom methods.
 */
@Repository
public class EmployeeCustomDaoImpl implements EmployeeCustomDao {

    @PersistenceContext
    private EntityManager em;

    /**
     * To get employee with email id.
     * @param employee
     * @return
     */
    @Override
    public Object getEmployeeByEmail(Employee employee) {
        Query query = em.createNativeQuery("select * from employee where email = '"+employee.getEmail()+"'");
        List employeeEntityList =  query.getResultList();
        return Objects.nonNull(employeeEntityList) && !CollectionUtils.isEmpty(employeeEntityList) ?  employeeEntityList.get(0) : null;
    }
}
