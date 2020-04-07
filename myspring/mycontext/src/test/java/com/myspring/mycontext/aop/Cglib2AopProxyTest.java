package com.myspring.mycontext.aop;

import com.myspring.mycontext.HelloWorldServiceImp;
import com.myspring.mycontext.context.ClassPathXmlApplicationContext;
import com.myspring.mycontext.HelloWorldService;
import org.junit.Test;

/**
 * @Description: cglib aop代理测试了
 * @Author: YANG
 * @Date: 2020/4/4 23:08
 * @Version: V1.0.0
 */
public class Cglib2AopProxyTest {
    @Test
    public void tset() throws Exception {
        // --------- helloWorldService without AOP
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("myspringcontextIOC.xml");
        HelloWorldService helloWorld = (HelloWorldService) context.getBean("helloWorldService");
        helloWorld.sayHello();


        // --------- helloWorldService with AOP
        //1.设置被代理对象（joinpoint）
        AdvisedSupport advicedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(helloWorld, HelloWorldServiceImp.class, HelloWorldService.class);
        advicedSupport.setTargetSource(targetSource);

        //2.设置拦截起（advice）
        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advicedSupport.setMethodInterceptor(timerInterceptor);

        //3.创建代理（proxy）
        Cglib2AopProxy cglib2AopProxy = new Cglib2AopProxy(advicedSupport);
        HelloWorldService proxy = (HelloWorldService) cglib2AopProxy.getProxy();
        proxy.sayHello();

    }
}
