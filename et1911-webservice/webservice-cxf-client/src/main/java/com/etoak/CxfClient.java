package com.etoak;

import com.etoak.service.HelloService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * Created by Liu on 2020/5/29.
 */
public class CxfClient {
    public static void main(String[] args) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

        factory.setAddress("http://localhost:8000/hello?wsdl");

        factory.setServiceClass(HelloService.class);

        HelloService services = (HelloService) factory.create();

        System.out.println(services);
        System.out.println(services.sayHello("CXF"));
    }
}