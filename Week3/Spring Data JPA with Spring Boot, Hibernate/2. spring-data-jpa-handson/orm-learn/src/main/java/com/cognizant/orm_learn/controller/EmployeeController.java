package com.cognizant.orm_learn.controller;

import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.services.EmployeeService;
import com.cognizant.orm_learn.services.HibernateEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private HibernateEmployeeService hibernateEmployeeService;

    @PostMapping("/spring-data-jpa/employee")
    public String addEmployeeWithSpringData(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return "Added with Spring Data JPA";
    }

    @PostMapping("/hibernate/employee")
    public String addEmployeeWithHibernate(@RequestBody Employee employee) {
        hibernateEmployeeService.addEmployee(employee);
        return "Added with Hibernate";
    }
}
