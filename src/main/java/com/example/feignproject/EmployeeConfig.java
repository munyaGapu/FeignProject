package com.example.feignproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmployeeConfig {
@Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository){
        return args -> {
            Employee employee=new Employee(
                    "Munyaradzi",
                    "IS DEV",
                    40000.00
            );
            Employee employee1=new Employee(
                    "Messi",
                    "IS bTECH",
                    90000.00
            );
           employeeRepository.saveAll(List.of(employee,employee1));

        };
    }

}
