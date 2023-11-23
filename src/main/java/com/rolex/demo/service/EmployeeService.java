package com.rolex.demo.service;

import com.rolex.demo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    Optional<Employee> findById(Integer id);

    Employee save(Employee employee);

    void deleteById(Integer id);
}
