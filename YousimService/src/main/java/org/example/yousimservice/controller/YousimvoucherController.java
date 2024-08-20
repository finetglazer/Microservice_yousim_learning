package org.example.yousimservice.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
// I want to add a log to log the api


@Log4j2
@RestController
@RequestMapping("api/v1/yousimvoucher")
public class YousimvoucherController extends BaseController {


    @Value("${yousimvoucher.uri}")
    private String YOUSIMVOUCHER_URI;

    @GetMapping("/getVoucher")
    public ResponseEntity<?> getVoucher() {
        String url = YOUSIMVOUCHER_URI + "/api/v1/test/hello";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("Going to the service: {}", url
        );
        return success(response);
    }
}
