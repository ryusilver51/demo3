package com.example.spring_jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring_jdbc.domain.Employee;
import com.example.spring_jdbc.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
  @Autowired
  private EmployeeService service;

  @RequestMapping("/execute")
  public String execute(Model model) {
    Employee employee = new Employee();
    employee.setName("佐藤次郎");
    employee.setAge(28);
    employee.setGender("男");
    employee.setDepartmentId(3);
    service.save(employee);

    Employee employee2 = service.load(1);
    System.out.println(employee2);
    service.deleteById(3);
    // service.findAll().forEach(System.out::println);

    List<Employee> employees = service.findAll();
    model.addAttribute("employees", employees);
    return "finished";
  }
}
