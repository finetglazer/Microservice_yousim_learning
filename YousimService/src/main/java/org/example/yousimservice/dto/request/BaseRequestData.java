package org.example.yousimservice.dto.request;

import lombok.Data;

@Data
public class BaseRequestData<T extends iRequestData> {
    private String wsCode;
    private String sessionId;
    private String token;
    private T wsRequest;
}
