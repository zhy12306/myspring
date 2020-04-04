package com.myspring.mycontext.test.aop;

import com.myspring.mycontext.aop.AdvicedSupport;
import com.myspring.mycontext.aop.JdkDynamicAopProxy;
import com.myspring.mycontext.aop.TargetSource;
import com.myspring.mycontext.context.ClassPathXmlApplicationContext;
import com.myspring.mycontext.test.HelloWorldService;
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
        HelloWorldService helloWorld = (HelloWorldService) context.getBean("helloWorld");
        helloWorld.sayHello();


        // --------- helloWorldService with AOP
        //1.设置被代理对象（joinpoint）
        AdvicedSupport advicedSupport = new AdvicedSupport();
        TargetSource targetSource = new TargetSource(helloWorld, HelloWorldService.class);
        advicedSupport.setTargetSource(targetSource);

        //2.设置拦截起（advice）
        TimerInterceptor timerInterceptor=new TimerInterceptor();
        advicedSupport.setMethodInterceptor(timerInterceptor);

        //3.创建代理（proxy）
        JdkDynamicAopProxy jdkDynamicAopProxy= new JdkDynamicAopProxy(advicedSupport);
        HelloWorldService proxy = (HelloWorldService) jdkDynamicAopProxy.getProxy();
        proxy.sayHello();

    }
}
