package com.kezeming.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : KZM
 * @create 2022/11/27 16:31
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/consul")
    public String paymentConsul() {
        return "springCloud with consul:" + serverPort + " \t" + UUID.randomUUID().toString();
    }
}
