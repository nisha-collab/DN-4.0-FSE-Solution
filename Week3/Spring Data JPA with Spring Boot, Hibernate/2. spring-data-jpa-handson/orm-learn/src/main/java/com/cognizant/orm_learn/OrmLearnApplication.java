package com.cognizant.orm_learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.services.EmployeeService;
import com.cognizant.orm_learn.services.HibernateEmployeeService;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private HibernateEmployeeService hibernateService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("START");

        Employee emp1 = new Employee(1, "SpringData John", 55000);
        employeeService.addEmployee(emp1);

        Employee emp2 = new Employee(2, "Hibernate Alice", 60000);
        hibernateService.addEmployee(emp2);

        System.out.println("END");
    }
}

