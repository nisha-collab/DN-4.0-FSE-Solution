package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.model.Department;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    private static List<Department> departmentList = new ArrayList<>();

    static {
        departmentList.add(new Department(1, "HR"));
        departmentList.add(new Department(2, "Finance"));
        departmentList.add(new Department(3, "Engineering"));
    }

    public List<Department> getAllDepartments() {
        return departmentList;
    }

    public Department getDepartmentById(int id) {
        return departmentList.stream()
                .filter(dept -> dept.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addDepartment(Department department) {
        departmentList.add(department);
    }

    public void updateDepartment(int id, Department updatedDepartment) {
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getId() == id) {
                departmentList.set(i, updatedDepartment);
                break;
            }
        }
    }

    public void deleteDepartment(int id) {
        departmentList.removeIf(dept -> dept.getId() == id);
    }
}
