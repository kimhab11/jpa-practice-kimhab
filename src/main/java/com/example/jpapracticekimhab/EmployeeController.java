package com.example.jpapracticekimhab;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.event.ListDataEvent;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/get-all")
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Employee getById(@PathVariable Long id) {
        return employeeRepository.findById(id);
    }

    @DeleteMapping("delete/{id}")
    public Employee deleteById(@PathVariable Long id){
        return employeeRepository.deleteById(id);
    }

    @PostMapping("add")
    public Employee add(
            @RequestParam String name,
            @RequestParam String gender,
            @RequestParam String email) {
        return employeeRepository.save(new Employee(null,name,gender,email));
    }

    @PutMapping("/update")
    public Employee update(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String gender,
            @RequestParam String email
    ){
        return employeeRepository.update(new Employee(id,name,gender,email));
    }
}
