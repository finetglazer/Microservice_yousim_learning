package org.example.yousimservice.service.Impl;

import org.example.yousimservice.dto.request.BaseRequestData;
import org.example.yousimservice.dto.request.api.ApiRequest;
import org.example.yousimservice.dto.response.api.ApiResponse;
import org.example.yousimservice.model.Api;
import org.example.yousimservice.repository.ApiRepository;
import org.example.yousimservice.repository.UserRepository;
import org.example.yousimservice.service.ApiService;
import org.example.yousimservice.utils.Application.ApplicationException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.yousimservice.model.User;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Service
public class ApiServiceImpl implements ApiService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ApiRepository apiRepository;
    @Override
    public ApiResponse addApi(BaseRequestData<ApiRequest> baseRequestData) throws ApplicationException {
        ApiResponse apiResponse = new ApiResponse();
        // find the user by session id and token
        ApiRequest apiRequest = (ApiRequest) baseRequestData.getWsRequest();
        // find the user by session id and token
        User user = userRepository.findUserBySessionAndToken(baseRequestData.getSessionId(), baseRequestData.getToken()).orElse(null);

        if (!ObjectUtils.isEmpty(user)) {
            if (!StringUtils.isEmpty(apiRequest.getNameApi())) {
                Api api = apiRepository.findByNameApi(apiRequest.getNameApi()).orElse(null);
                if (!ObjectUtils.isEmpty(api)) {
                    throw new ApplicationException("ERR_0000005", "api");
                } else {
                    api = new Api();
                    BeanUtils.copyProperties(apiRequest, api);
                    apiRepository.save(api);

                    BeanUtils.copyProperties(api, apiResponse);
                    return apiResponse;
                }
            } else {
                throw new ApplicationException("ERR_0000004", "api");
            }

        } else {
            throw new ApplicationException("ERR_0000003");
        }

    }
}
