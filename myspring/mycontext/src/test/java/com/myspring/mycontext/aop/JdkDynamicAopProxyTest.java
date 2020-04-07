package com.myspring.mycontext.aop;

import com.myspring.mycontext.HelloWorldService;
import com.myspring.mycontext.HelloWorldServiceImp;
import com.myspring.mycontext.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @Description: aop动态代理测试l类
 * @Author: YANG
 * @Date: 2020/4/4 21:14
 * @Version: V1.0.0
 */
public class JdkDynamicAopProxyTest {
    @Test
    public void tset() throws Exception {
        // --------- helloWorldService without AOP
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("myspringcontextIOC.xml");
        HelloWorldService helloWorld = (HelloWorldService) context.getBean("helloWorldService");
        helloWorld.sayHello();


        // --------- helloWorldService with AOP
        //1.设置被代理对象（joinpoint）
        AdvisedSupport advicedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(helloWorld, HelloWorldServiceImp.class,HelloWorldService.class);
        advicedSupport.setTargetSource(targetSource);

        //2.设置拦截起（advice）
        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advicedSupport.setMethodInterceptor(timerInterceptor);

        //3.创建代理（proxy）
        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advicedSupport);
        Object proxy = jdkDynamicAopProxy.getProxy();
        HelloWorldService helloWorldService = (HelloWorldService) proxy;
        helloWorldService.sayHello();

    }
}
