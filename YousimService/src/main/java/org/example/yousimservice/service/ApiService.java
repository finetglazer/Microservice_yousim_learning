package org.example.yousimservice.service;

import org.example.yousimservice.dto.request.BaseRequestData;
import org.example.yousimservice.dto.request.api.ApiRequest;
import org.example.yousimservice.dto.response.api.ApiResponse;
import org.example.yousimservice.utils.Application.ApplicationException;

public interface ApiService {
    ApiResponse addApi(BaseRequestData<ApiRequest> baseRequestData) throws ApplicationException;
}
