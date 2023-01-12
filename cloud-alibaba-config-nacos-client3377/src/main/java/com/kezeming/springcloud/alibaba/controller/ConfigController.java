package com.kezeming.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : KZM
 * @create 2022/12/21 10:37
 */
@RestController
@RefreshScope  // 支持Nacos动态刷新功能
public class ConfigController {
    @Value("${config.info}")
    public String configInfo;

    @GetMapping(value = "/config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
