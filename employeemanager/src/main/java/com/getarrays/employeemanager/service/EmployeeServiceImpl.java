package com.getarrays.employeemanager.service;

import com.getarrays.employeemanager.exceptions.UserNotFounfException;
import com.getarrays.employeemanager.model.Employee;
import com.getarrays.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl {

    private  final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return  employeeRepository.save(employee);

    }

    public List<Employee> listOfEmployees(){
        return employeeRepository.findAll();
    }

    public  Employee updateEmployee(Employee employee){

        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long Id){
        return employeeRepository.findEmployeeById(Id)
                .orElseThrow(()->new UserNotFounfException("user by id" + Id + "was not found"));
    }


    public void deleteEmployee(Long Id){
        employeeRepository.deleteById(Id);
    }




}
