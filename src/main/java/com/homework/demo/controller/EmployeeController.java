package com.homework.demo.controller;

import com.homework.demo.entity.Employee;
import com.homework.demo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl EmployeeServiceImpl;
    @RequestMapping("/")
    public String index()
    {
        return "init page";
    }
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return EmployeeServiceImpl.getEmployees();
    }

    @DeleteMapping("/delete:id={id}")
    public List<Employee>  deleteEmployee(@PathVariable int id){
        EmployeeServiceImpl.deleteEmployee(id);
        return EmployeeServiceImpl.getEmployees();
    }

    @PutMapping("/add:id={id}&name={name}&age={age}&gender={gender}")
    public List<Employee>  addEmployee(@PathVariable int id,@PathVariable String name,@PathVariable int age,@PathVariable String gender){
        EmployeeServiceImpl.addEmployee(new Employee(id,name,age,gender));
        return EmployeeServiceImpl.getEmployees();
    }

    @PostMapping("/update:id={id}&name={name}&age={age}&gender={gender}")
    public List<Employee>  updateEmployee(@PathVariable int id,@PathVariable String name,@PathVariable int age,@PathVariable String gender){
        EmployeeServiceImpl.updateEmployee(new Employee(id,name,age,gender));
        return EmployeeServiceImpl.getEmployees();
    }

    @GetMapping("/find:id={id}")
    public Employee findEmployee(@PathVariable int id){
        return EmployeeServiceImpl.findEmployee(id);
    }
}
