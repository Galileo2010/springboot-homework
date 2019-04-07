package com.homework.demo.Dao;

import com.alibaba.fastjson.JSONObject;
import com.homework.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import sun.misc.IOUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {
    @Value("classpath:data.json")
    Resource data;

    private List<Employee> employees = new ArrayList<>();

    @PostConstruct
    public void init(){
        String json = null;
        try {
            json = new String(IOUtils.readFully(data.getInputStream(), -1,true));
        } catch (IOException e) {
            e.printStackTrace();
        }
        employees = JSONObject.parseArray(json, Employee.class);
    }

    public List<Employee> getEmployees(){
        return employees;
    }
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void deleteEmployee(int id) {
        employees.remove(findEmployee(id));
    }

    public void updateEmployee(Employee employee) {
        int index = employees.indexOf(findEmployee(employee.getId()));
        employees.set(index, employee);
    }

    public Employee findEmployee(int id) {
        return employees.stream().filter(employee -> employee.getId() == id).findFirst().orElse(null);
    }
}
