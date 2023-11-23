package com.rolex.demo.service;

import com.rolex.demo.dao.EmployeeRepository;
import com.rolex.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Integer id) {

        Employee employee = null;
        Optional<Employee> response = employeeRepository.findById(id);

        if(response.isPresent()){
            employee = response.get();
        }
        else{
            throw new RuntimeException("Cannot find employee");
        }

        return Optional.of(employee);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        Optional<Employee> response = employeeRepository.findById(id);

        if(response.isPresent()){
            employeeRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("Cannot find employee");
        }

    }

}
