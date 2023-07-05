package com.example.feignproject;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

   public  List<Employee> workerList(){
        return employeeRepository.findAll();
    }
    public void addNew(Employee employee){
        Optional<Employee> employeeOptional=employeeRepository.findByName(employee.getName());
        if(employeeOptional.isPresent()){
            throw new IllegalStateException("try new unique name");
        }
        employeeRepository.save(employee);
    }

    public void delete(Long id){
        boolean exist=employeeRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException("employee not found");
        }
        employeeRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, String name,String dept){
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new IllegalStateException("student not found")

        );
        Optional<Employee> employeeOptional=employeeRepository.findByName(name);
        if(employeeOptional.isPresent()){
            throw new IllegalStateException("same name provided");
        }
        employee.setName(name);
        employee.setDepartment(dept);
    }

}
