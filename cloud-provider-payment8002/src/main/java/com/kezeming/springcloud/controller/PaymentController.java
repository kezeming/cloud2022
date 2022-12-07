package com.kezeming.springcloud.controller;

import com.kezeming.springcloud.entities.CommonResult;
import com.kezeming.springcloud.entities.Payment;
import com.kezeming.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : KZM
 * @create 2022/11/24 00:27
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    //传给前端JSON
    @PostMapping(value = "/payment/create")    //写操作POST
    public CommonResult<Integer> create(@RequestBody Payment payment){

        //由于在mapper.xml配置了useGeneratedKeys="true" keyProperty="id"，会将自增的id封装到实体类中
        int result = paymentService.create(payment);

        log.info("*****插入结果：" + result);

        if(result > 0){
            return new CommonResult<>(200, "插入数据库成功, serverPort: " + serverPort, result);
        }else {
            return new CommonResult<>(444,"插入数据库失败", null);
        }
    }

    //传给前端JSON
    @GetMapping(value = "/payment/get/{id}")    //写操作POST
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);

        log.info("*****查询结果：" + payment);

        if(payment != null){
            return new CommonResult<>(200, "查询数据库成功, serverPort" + serverPort, payment);
        }else {
            return new CommonResult<>(444,"查询ID:"+id+"没有对应记录", null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("*********service: "+ service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    //服务提供方8002故意写暂停程序
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
