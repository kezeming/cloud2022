package com.kezeming.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : KZM
 * @create 2022/11/24 00:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    //404 not_found     ：    Integer String
    private Integer code;
    private String message;

    //这不是针对某一个实体类的Josn串封装类
    private T data;

    //当T是null时，定义一个两个参数的构造
    public CommonResult(Integer code, String message){
        this(code, message, null);
    }
}
