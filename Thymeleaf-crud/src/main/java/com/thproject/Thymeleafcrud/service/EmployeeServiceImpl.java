package com.thproject.Thymeleafcrud.service;

import com.thproject.Thymeleafcrud.model.Employee;
import com.thproject.Thymeleafcrud.repository.EmployeeRepository;
import com.thproject.Thymeleafcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repo;


    @Override
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.repo.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> optional = repo.findById(id);
        Employee employee = null;
        if(optional.isPresent()){
            employee = optional.get();
        } else{
            throw new RuntimeException("Employee of Id: "+id+" is Not found!!");
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        this.repo.deleteById(id);
    }
}
