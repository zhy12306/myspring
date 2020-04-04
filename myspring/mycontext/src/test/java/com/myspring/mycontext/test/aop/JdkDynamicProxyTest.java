package com.myspring.mycontext.test.aop;

import com.myspring.mycontext.aop.AdvicedSupport;
import com.myspring.mycontext.aop.JdkDynamicProxy;
import com.myspring.mycontext.aop.TargetSource;
import com.myspring.mycontext.context.ApplicationContext;
import com.myspring.mycontext.context.ClassPathXmlApplicationContext;
import com.myspring.mycontext.test.HelloWorld;
import com.myspring.mycontext.test.HelloWorldService;
import org.junit.Test;

/**
 * @Description: jdk动态代理测试类
 * @Author: YANG
 * @Date: 2020/4/3 18:03
 * @Version: V1.0.0
 */
public class JdkDynamicProxyTest {

    @Test
    public void test() throws Exception {
        //-----------helloworld without AOP
        ApplicationContext context = new ClassPathXmlApplicationContext("myspringcontextIOC.xml");
        HelloWorld helloworld = (HelloWorld) context.getBean("helloWorld");
        helloworld.sayHello();

        //-----------helloworld with AOP
        //设置被代理对象（JoinPoint）
        AdvicedSupport advicedSupport = new AdvicedSupport();
        TargetSource targetSource = new TargetSource(HelloWorldService.class, helloworld);
        advicedSupport.setTargetSource(targetSource);

        //设置拦截器（Advice)
        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advicedSupport.setMethodInterceptor(timerInterceptor);

        //创建代理
        JdkDynamicProxy jdkDynamicProxy = new JdkDynamicProxy(advicedSupport);
        HelloWorldService helloWorldProxy = (HelloWorldService) jdkDynamicProxy.getProxy();

        //基于aop调用
        helloWorldProxy.sayHello();



    }

}
