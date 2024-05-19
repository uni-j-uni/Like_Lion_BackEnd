package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    private final EmployeeJpaRepository repository;

    public Controller(EmployeeJpaRepository repository) { this.repository = repository; }

    @PostMapping("/employee")
    public String createEmployee(@RequestBody Employee employee) {
        repository.save(employee);
        return employee.toString();
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return this.repository.findAll();
    }

    @PatchMapping("/employee/{id}")
    public String patchEmployee(@RequestBody Employee updatedEmployee, @PathVariable int id) {
        Optional<Employee> optionalEmployee = repository.findById(id);
        Employee employee = optionalEmployee.get();

        if (updatedEmployee.getName() != null) employee.setName(updatedEmployee.getName());
        if (updatedEmployee.getDepartment() != null) employee.setDepartment(updatedEmployee.getDepartment());
        else employee.setDepartment("백엔드");
        if (updatedEmployee.getAge() != null) employee.setAge(updatedEmployee.getAge());

        repository.save(employee);
        return  employee.toString();
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable int id) { repository.deleteById(id); }
}
