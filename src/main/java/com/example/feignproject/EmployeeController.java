package com.example.feignproject;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<Employee> employees(){
        return employeeService.workerList();
    }

    @PostMapping(path = "/add",consumes = "application/json")
    public void add(@RequestBody Employee employee){
        employeeService.addNew(employee);
    }
    @DeleteMapping(path = "{empid}")
    public void delete(@PathVariable("empid") Long empid ){
        employeeService.delete(empid);
    }
    @PutMapping(path = "{empid}")
    public void update(@PathVariable("empid") Long empid,@RequestParam(required = false) String name,
                       @RequestParam(required = false) String dept){
        employeeService.update(empid,name,dept);
    }

}
