package org.example.webfluxdemo.payload.Response;

import lombok.Data;

@Data
public class EmployeeResponse {

    private Long id;
    private String name;

    public EmployeeResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
