package com.homework.demo.service;

import com.homework.demo.Dao.EmployeeDao;
import com.homework.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    @Override
    public Employee findEmployee(int id) {
        return employeeDao.findEmployee(id);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }
}
