package com.etoak.service.impl;

import com.etoak.service.HelloService;

import javax.jws.WebService;

/**
 * Created by 22066 on 2020/5/29.
 */

@WebService(serviceName = "HelloServiceWS",portName = "HelloServiceWSPost")

public class HelloServiceImpl implements HelloService{
    @Override
    public String sayHello(String name) {
        System.out.println("服务端被调用了");
        return "Hello" + name;
    }
}
