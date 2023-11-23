package com.rolex.demo.rest;

import com.rolex.demo.entity.Employee;
import com.rolex.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;

    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Optional<Employee> findById(@PathVariable Integer employeeId) {
        return employeeService.findById(employeeId);

    }

    @PostMapping("/employee")
    public Employee add(@RequestBody Employee employee){

        return employeeService.save(employee);

    }

    @PutMapping("/employee")
    public Employee update(@RequestBody Employee employee){

        return employeeService.save(employee);

    }

    @DeleteMapping("/employee/{employeeId}")
    public String delete(@PathVariable Integer employeeId){
        employeeService.deleteById(employeeId);

        return "Deleted";
    }

}
