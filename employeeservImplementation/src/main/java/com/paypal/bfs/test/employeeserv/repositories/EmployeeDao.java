package com.paypal.bfs.test.employeeserv.repositories;

import com.paypal.bfs.test.employeeserv.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeEntity, Long> {
}
