package com.etoak;

import com.etoak.service.impl.HelloServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by 22066 on 2020/5/29.
 */
public class JdkWsService {
    public static void main(String[] args) {
        Endpoint.publish( "http://localhost:8080/hello",new HelloServiceImpl());



        System.out.println("Server start ...");
    }
}
