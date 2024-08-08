package org.example.yousimservice.controller;

import org.example.yousimservice.SocialLoginApi;
import org.example.yousimservice.dto.request.BaseRequestData;
import org.example.yousimservice.dto.request.customer.SocialTokenRequest;
import org.example.yousimservice.utils.Application.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;


@Controller
@RequestMapping("/api/v1")
public class CustomerController extends BaseController {
    @Autowired
    private SocialLoginApi socialLoginApi;

    @PostMapping("/socialLogin")
    public ResponseEntity<?> loginFb(@RequestBody BaseRequestData<SocialTokenRequest> request)  throws ApplicationException, IOException {
        String accessToken = request.getWsRequest().getAccessToken();
        String provider = request.getWsRequest().getProvider();
        return success(socialLoginApi.execute(accessToken, provider));
    }
}
