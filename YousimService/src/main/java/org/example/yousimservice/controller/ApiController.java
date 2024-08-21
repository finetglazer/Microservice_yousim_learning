package org.example.yousimservice.controller;

import org.example.yousimservice.dto.request.BaseRequestData;
import org.example.yousimservice.dto.request.api.ApiRequest;
import org.example.yousimservice.dto.response.api.ApiResponse;
import org.example.yousimservice.service.ApiService;
import org.example.yousimservice.utils.Application.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
public class ApiController extends BaseController {
    @Autowired
    private ApiService apiService;
    @PostMapping("/addApi")
    public ResponseEntity<ApiResponse> addApi(@RequestBody BaseRequestData<ApiRequest> baseRequestData) throws ApplicationException {

        return success(apiService.addApi(baseRequestData));
    }
}
