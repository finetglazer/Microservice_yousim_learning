package org.example.webfluxdemo.service.Impl;

import org.example.webfluxdemo.payload.Response.BaseResponse;
import org.example.webfluxdemo.service.YousimVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class YousimVoucherServiceImpl implements YousimVoucherService {
    @Autowired
    private WebClient webClient;

    @Override
    public Mono<?> getHello() {
        return webClient.get()
                .uri("http://localhost:8081/api/v1/test/hello")
                .retrieve()
                .bodyToMono(String.class)
                .map(response -> new BaseResponse(1, response))
                .defaultIfEmpty(new BaseResponse(0, "No response"));
    }
}
