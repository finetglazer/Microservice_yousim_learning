package org.example.webfluxdemo.controller;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.example.webfluxdemo.service.YousimVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/yousimvoucher")
public class YousimVoucherController {
    @Autowired
    private YousimVoucherService yousimVoucherService;

    @GetMapping("/getHello")
    public ResponseEntity<Mono<?>> getHello() {
        return ResponseEntity.ok(yousimVoucherService.getHello());
    }

}
