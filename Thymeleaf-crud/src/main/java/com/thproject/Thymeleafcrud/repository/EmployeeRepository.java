package com.thproject.Thymeleafcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.thproject.Thymeleafcrud.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long > {
}
