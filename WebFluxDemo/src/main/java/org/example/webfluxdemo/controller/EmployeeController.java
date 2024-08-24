package org.example.webfluxdemo.controller;

import org.example.webfluxdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/findById/{id}")
    public ResponseEntity<Mono<?>> findById(@PathVariable Long id) {
//        return employeeService.findById(id)
//                .map(employee -> ResponseEntity.ok(employee))
//                .defaultIfEmpty(ResponseEntity.notFound().build());
        // There are two case empty and not empty, and in empty case we also should return 200 status and a note that the employee is not found
        return ResponseEntity.ok(employeeService.findById(id));


    }

    @GetMapping("/findAll")
    public ResponseEntity<Mono<?>> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

}
