package org.example.webfluxdemo.service;

import org.example.webfluxdemo.payload.Response.BaseResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    Mono<?> findById(Long id);
    Mono<?> findAll();
}
