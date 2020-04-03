package com.myspring.mycontext.test.context;

import com.myspring.mycontext.context.ClassPathXmlApplicationContext;
import com.myspring.mycontext.test.HelloWorld;
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
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        helloWorld.sayHello();

    }
}
