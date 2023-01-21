package com.employee.Controller;

import com.employee.Entity.Employee;
import com.employee.Service.Employee_Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
public class Employee_Controller {

    @Autowired
    private Employee_Service service;

   Logger logger = LogManager.getLogger(Employee_Controller.class);

     @PostMapping("/addEmployee")

    public Employee addEmployee( @Valid @RequestBody  Employee employee)
    {
        logger.info("Employee is adding");
     return service.saveEmployee(employee);
    }

    @GetMapping("/getEmployee/{id}")
    public Employee getEmployeebyId(@Valid  @PathVariable int id)
    {
        return service.getEmployeebyId(id);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
        return service.deleteEmployeebyId(id);
    }

    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        return service.updateEmployee(employee);
    }


}
