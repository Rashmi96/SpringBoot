package com.student.database.service;

import com.student.database.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeService extends CrudRepository<Employee,Integer> {

}
