package com.bszhang.java.learn.spring.aop;

import org.junit.Test;

public class SimpleAOPTest {
    @Test
    public void getProxy() {
        MethodInvocation logTask = () -> System.out.println("log task start");
        HelloServiceImpl helloServiceImpl = new HelloServiceImpl();

        Advice beforeAdvice = new BeforeAdvice(helloServiceImpl, logTask);

        HelloService helloServiceImplProxy = (HelloService) SimpleAOP.getProxy(helloServiceImpl, beforeAdvice);
        helloServiceImplProxy.sayHelloWorld();
    }
}
