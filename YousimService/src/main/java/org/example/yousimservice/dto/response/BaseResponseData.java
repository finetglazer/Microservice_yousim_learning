package org.example.yousimservice.dto.response;

import lombok.Data;

@Data
public class BaseResponseData<T> {
    private String Code;
    private String message;
    private T wsResponse;
}
