package com.kezeming.myrule;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : KZM
 * @create 2022/11/27 19:48
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule customLoadBalance() {
//        return new RetryRule();
//        return new BestAvailableRule();
//        return new WeightedResponseTimeRule();
        return new RandomRule();  // 定义为随机
    }
}
