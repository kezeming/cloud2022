package com.kezeming.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : KZM
 * @create 2022/11/28 15:16
 */
public interface PaymentHystrixService {
    //正常访问，肯定OK的方法
    public String paymentInfo_OK(Integer id);

    //模拟拥堵的情况
    public String paymentInfo_Timeout(Integer id);
}
