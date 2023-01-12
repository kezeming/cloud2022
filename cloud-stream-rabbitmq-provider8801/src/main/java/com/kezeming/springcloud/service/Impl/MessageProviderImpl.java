package com.kezeming.springcloud.service.Impl;

import com.kezeming.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : KZM
 * @create 2022/12/8 22:09
 */
// @Service：这里不需要了，这里不是传统的controller调用service。这个service是和rabbitMQ打交道的
@EnableBinding(Source.class) // 定义消息的推送管道
@Slf4j
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;  // 消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        // 通过output这个管道向消息中间件发送消息
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("*******serial: " + serial);
        return null;
    }
}
