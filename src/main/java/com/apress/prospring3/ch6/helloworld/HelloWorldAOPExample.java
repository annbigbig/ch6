package com.apress.prospring3.ch6.helloworld;

import org.springframework.aop.framework.ProxyFactory;

public class HelloWorldAOPExample {

    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();
        
        // create the proxy
        ProxyFactory pf = new ProxyFactory();

        pf.addAdvice(new MessageDecorator());
        pf.setTarget(target);


        MessageWriter proxy = (MessageWriter) pf.getProxy();
        
        // write the messages
        target.writeMessage();
        System.out.println("");
        proxy.writeMessage();
    }
}