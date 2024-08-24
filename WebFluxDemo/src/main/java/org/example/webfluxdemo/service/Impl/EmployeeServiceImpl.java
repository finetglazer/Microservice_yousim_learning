package org.example.webfluxdemo.service.Impl;

import org.example.webfluxdemo.model.Employee;
import org.example.webfluxdemo.payload.Response.BaseResponse;
import org.example.webfluxdemo.payload.Response.BaseResponse;
import org.example.webfluxdemo.payload.Response.EmployeeResponse;
import org.example.webfluxdemo.repository.EmployeeRepository;
import org.example.webfluxdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Mono<?> findById(Long id) {

        return employeeRepository.findById(id)
                .map(employee -> new BaseResponse(1, new EmployeeResponse(employee.getId(), employee.getName())))
                .defaultIfEmpty(new BaseResponse(0, "Employee not found"));
    }

    @Override
    public Mono<?> findAll() {
        Flux<EmployeeResponse> employeeResponseFlux = employeeRepository.findAll().map(employee -> new EmployeeResponse(employee.getId(), employee.getName()));


        return employeeResponseFlux.collectList().flatMap(employees -> {
            if (employees.isEmpty()) {
                return Mono.just(new BaseResponse(0, "No employee found"));
            } else {
                return Mono.just(new BaseResponse(1, employees));
            }
        });
    }


}
