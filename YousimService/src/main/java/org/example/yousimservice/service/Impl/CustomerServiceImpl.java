package org.example.yousimservice.service.Impl;

import org.example.yousimservice.constant.Const;
import org.example.yousimservice.dto.request.customer.SocialAccountInfo;
import org.example.yousimservice.dto.response.Customer.CustomerResponse;
import org.example.yousimservice.model.Customer;
import org.example.yousimservice.model.User;
import org.example.yousimservice.repository.UserRepository;
import org.example.yousimservice.service.CustomerService;
import org.example.yousimservice.utils.Application.ApplicationException;
import org.example.yousimservice.utils.GenCodeUtils;
import org.example.yousimservice.utils.PasswordEncryption;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.yousimservice.repository.CustomerRepository;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private GenCodeUtils genCodeUtils;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HttpServletRequest httpServletRequest;


    @Override
    public CustomerResponse loginSocialAccount(SocialAccountInfo accountInfo) throws ApplicationException {
        CustomerResponse customerResponse = new CustomerResponse();
        Customer customer = customerRepository.findByProviderAndProviderId(accountInfo.getProvider(), accountInfo.getId());

        if (ObjectUtils.isEmpty(customer) && !StringUtils.isEmpty(accountInfo.getEmail())) {
            customer = customerRepository.findByEmail(accountInfo.getEmail());
        }

        if (ObjectUtils.isEmpty(customer)) {
            customer = new Customer();
            customer.setCusName(accountInfo.getName());
            customer.setCreateTime(LocalDateTime.now());
            customer.setUpdateTime(LocalDateTime.now());
            customer.setProvider(accountInfo.getProvider());
            customer.setProviderId(accountInfo.getId());
            customer.setStatus(Const.ACTIVE);
            customerRepository.save(customer);
            User u = null;
            User user = new User();
            if (!StringUtils.isEmpty(accountInfo.getEmail())) {
                customer.setEmail(accountInfo.getEmail());
                u = userRepository.findByEmail(accountInfo.getEmail()).orElse(null);
                user.setUsername(accountInfo.getEmail().substring(0, accountInfo.getEmail().indexOf("@")));
            } else {
                user.setUsername(accountInfo.getName().replaceAll(" ", "_"));
            }
            if (ObjectUtils.isEmpty(u)) {
                user.setStatusUser(Const.ACTIVE);
                user.setCreateTime(LocalDateTime.now());
                user.setRoleId(Const.ROLE_CUSTOMER);
                user.setUpdateTime(LocalDateTime.now());
                user.setCusId(customer.getCusId());
                user.setEmail(accountInfo.getEmail());
                user.setPassword(PasswordEncryption.encryteBCryptPassword(Const.PASSWORD_DEFAULT + customer.getCusId()));
                String tokenData = GenCodeUtils.encrypt(user.getUsername() + "_" + user.getRoleId() + "_" + user.getUserId(), Const.KEY, Const.SECRET_KEY);
                HttpSession httpSession = httpServletRequest.getSession();
                httpSession.setMaxInactiveInterval(60 * 60 * 24);
                user.setSession(httpSession.getId());
                user.setToken(tokenData);
                userRepository.save(user);
                //                customer.setSession(httpSession.getId());
                BeanUtils.copyProperties(customer, customerResponse);
                customerResponse.setToken(user.getToken());
                customerResponse.setSession(user.getSession());
            }
        } else {
            User user = userRepository.findByCustomerId(customer.getCusId()).orElse(null);
            assert user != null;
//            System.out.println(user.getUsername() + "_" + user.getRoleId() + "_" + user.getUserId());
            String tokenData = GenCodeUtils.encrypt(user.getUsername() + "_" + user.getRoleId() + "_" + user.getUserId(), Const.KEY, Const.SECRET_KEY);
            user.setToken(tokenData);
            userRepository.save(user);

            HttpSession httpSession = httpServletRequest.getSession();
            httpSession.setMaxInactiveInterval(60 * 60 * 24);
            BeanUtils.copyProperties(customer, customerResponse);
            customerResponse.setToken(user.getToken());
            customerResponse.setSession(user.getSession());
        }

        return customerResponse;
    }
}
