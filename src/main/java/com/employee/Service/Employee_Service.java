package com.employee.Service;

import com.employee.Entity.Employee;
import com.employee.Repository.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Employee_Service {

    @Autowired
    private Dao dao;

    public Employee saveEmployee (Employee employee)
    {
        return dao.save(employee);
    }

    public Employee getEmployeebyId(int id)
    {
        return dao.findById(id).orElse(null);
    }

    public String deleteEmployeebyId(int id)
    {
         dao.deleteById(id);
         return "employee deleted" + id;
    }

    public Employee updateEmployee(Employee employee)
    {
        Employee existingEmployee=dao.findById(employee.getId()).orElse(null);
        existingEmployee.setName(employee.getName());
        existingEmployee.setCompany(employee.getCompany());
        return dao.save(existingEmployee);
    }



}
