package com.managment.Employee.services;

import com.managment.Employee.model.Employee;
import com.managment.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.PresentationDirection;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee createEmployee(Employee employee){
        return repository.save(employee);
    }

    public List<Employee> getAllEmployee(){
        return repository.findAll();
    }

    public Optional<Employee> getEmployeeByID(Integer id){
        return repository.findById(id);
    }

    public Employee updateEmployee(Integer id, Employee updatedEmployee){

        Optional<Employee> existingEmployee = repository.findById(id);
        existingEmployee.get().setName(updatedEmployee.getName());
        existingEmployee.get().setEmail(updatedEmployee.getEmail());
        existingEmployee.get().setPosition(updatedEmployee.getPosition());
        existingEmployee.get().setSalary(updatedEmployee.getSalary());
        return repository.save(existingEmployee.get());

    }

    public void deleteEmployee(Integer id) {
        repository.deleteById(id);
        System.out.println("Employee "+ id+ "is succesfully Deleted");
    }
}
