package com.example.Hola.Controller;

import com.example.Hola.Service.EmployeeService;
import com.example.Hola.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


//    public EmployeeController(EmployeeService employeeService) {
//        super();
//        this.employeeService = employeeService;
//    }

    //build create employee REST API
    @PostMapping("/add")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
    {

            return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);

    }

    //build all employee REST API
    @GetMapping("/getAll")
    public List<Employee> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

    //build get employee by id REST API

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId)
    {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }

    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee)
    {
         return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id)
    {
        //delete employee from DB
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>
                ("Employee deleted successfully!.", HttpStatus.OK);
    }


}
