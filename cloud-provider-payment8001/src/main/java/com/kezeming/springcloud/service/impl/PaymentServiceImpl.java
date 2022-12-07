package com.kezeming.springcloud.service.impl;

import com.kezeming.springcloud.dao.PaymentDao;
import com.kezeming.springcloud.entities.Payment;
import com.kezeming.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : KZM
 * @create 2022/11/24 00:26
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }

}
