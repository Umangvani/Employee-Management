package com.managment.Employee.controller;

import com.managment.Employee.model.Employee;
import com.managment.Employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/health")
    public String healthCheck(){
        return "Welcome too My Server!";
    }

    @PostMapping("/add")
    public ResponseEntity<?> AddEmployee(@RequestBody Employee employee){
       Employee newEmployee = service.createEmployee(employee);
       return new ResponseEntity<>(newEmployee, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List> getAllEmployee(){
        return new ResponseEntity<>(service.getAllEmployee(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Integer id){
        return new ResponseEntity<>(service.getEmployeeByID(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, Employee updatedEmployee){
        return new ResponseEntity<>(service.updateEmployee(id,updatedEmployee), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletebyId(@PathVariable Integer id){
        service.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

}
