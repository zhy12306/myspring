package com.myspring.mycontext.context;

import com.myspring.mycontext.HelloWorldServiceImp;
import org.junit.Test;

/**
 * @Description: 容器测试类
 * @Author: YANG
 * @Date: 2020/4/3 16:02
 * @Version: V1.0.0
 */
public class ApplicationContextTest {
    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("myspringcontextIOC.xml");
        HelloWorldServiceImp helloWorld = (HelloWorldServiceImp) context.getBean("helloWorld");
        helloWorld.sayHello();

    }
}
