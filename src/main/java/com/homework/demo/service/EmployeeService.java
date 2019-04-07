package com.homework.demo.service;

import com.homework.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public void addEmployee(Employee employee);
    public void deleteEmployee(int id);
    public void updateEmployee(Employee employee);
    public Employee findEmployee(int id);
    public List<Employee> getEmployees();
}
