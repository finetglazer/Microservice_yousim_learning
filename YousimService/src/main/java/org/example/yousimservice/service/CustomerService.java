package org.example.yousimservice.service;

import org.example.yousimservice.dto.request.customer.SocialAccountInfo;
import org.example.yousimservice.dto.response.Customer.CustomerResponse;
import org.example.yousimservice.utils.Application.ApplicationException;

public interface CustomerService {
    CustomerResponse loginSocialAccount(SocialAccountInfo accountInfo) throws ApplicationException;
}
