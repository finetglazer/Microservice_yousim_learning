package org.example.yousimservice.controller;

import org.example.yousimservice.dto.request.BaseRequestData;
import org.example.yousimservice.dto.request.aboutUs.AboutUsAndLanguageRequest;
import org.example.yousimservice.dto.response.aboutUs.ListAboutUsLanguageResponse;
import org.example.yousimservice.service.AboutUsService;
import org.example.yousimservice.utils.Application.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/")
public class AboutUsController extends BaseController {
    @Autowired
    private AboutUsService aboutUsService;

    @PostMapping("/aboutUs")
    public ResponseEntity<?> listAboutUs(@RequestBody BaseRequestData<AboutUsAndLanguageRequest> baseRequestData) {
        try {
            ListAboutUsLanguageResponse aboutUsLanguageResponse = aboutUsService.listAboutUs(baseRequestData);
            return success(aboutUsLanguageResponse);
        } catch (ApplicationException e) {
            return error(e.getCode(), e.getMessage());
        }
    }
}
