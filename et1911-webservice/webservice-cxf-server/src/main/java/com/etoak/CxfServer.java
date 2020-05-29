package com.etoak;

import com.etoak.service.HelloService;
import com.etoak.service.impl.HelloServiceImpl;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * Created by 22066 on 2020/5/29.
 */
public class CxfServer {
    public static void main(String[] args) {
        //创建JaxWSServerFactory
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        //设置wsdl地址
        factory.setAddress("http://localhost:8000/hello");
        //设置法波的服务接
         factory.setServiceClass(HelloService.class);

        //设置发布的服务实现

        factory.setServiceBean(new HelloServiceImpl());

        Server server = factory.create();
        server.start();
        System.out.println("Service start...");

    }

}
