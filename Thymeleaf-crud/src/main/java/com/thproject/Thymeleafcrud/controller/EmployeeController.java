package com.thproject.Thymeleafcrud.controller;

import com.thproject.Thymeleafcrud.model.Employee;
import com.thproject.Thymeleafcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    //display list of emps

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees",service.getAllEmployees());
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        //create a model attribute to bind form data
        Employee employee = new Employee();

        model.addAttribute("employee",employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        //save to DB
        service.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable(value="id") long id, Model model){
        //get Employee from the service
        Employee employee=service.getEmployeeById(id);

        //set employee as model attribute to pre-populate the form
        model.addAttribute("employee",employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable( value = "id" ) long id){
        //call delete method.
        this.service.deleteEmployeeById(id);
        return "redirect:/";
    }
}
