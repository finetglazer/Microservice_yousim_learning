package org.example.yousimservice;

import com.google.gson.Gson;
import lombok.Data;
import org.apache.http.client.fluent.Request;
import org.example.yousimservice.dto.request.customer.SocialAccountInfo;
import org.example.yousimservice.dto.response.Customer.CustomerResponse;
import org.example.yousimservice.service.CustomerService;
import org.example.yousimservice.utils.Application.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


@Data
@Component
public class SocialLoginApi {
    @Value("${facebook.link.get.user.info}")
    private String FACEBOOK_GET_USER_INFO;
    @Value("${google.link.get.user.info}")
    private String GOOGLE_lINK_GET_USER_INFO;
    @Autowired
    private CustomerService customerService;

    public CustomerResponse execute(String accessToken, String provider) throws IOException, ApplicationException {
        SocialAccountInfo socialAccountInfo;
        try {
            // I just test google
            String link = String.format(GOOGLE_lINK_GET_USER_INFO, accessToken);
//            String response = Request.Get(link).execute().returnContent().asString();
//            socialAccountInfo = new Gson().fromJson(response, SocialAccountInfo.class);
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(link, String.class);
            socialAccountInfo = new Gson().fromJson(response, SocialAccountInfo.class);
        } catch (Exception e) {
            throw new ApplicationException("ERR_0000710");
        }

        socialAccountInfo.setProvider(provider);
        return customerService.loginSocialAccount(socialAccountInfo);
    }
}
