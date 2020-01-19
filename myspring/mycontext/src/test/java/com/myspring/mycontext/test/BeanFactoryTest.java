package com.myspring.mycontext.test;

import com.myspring.mycontext.BeanDefinition;
import com.myspring.mycontext.BeanFactory;
import org.junit.Before;
import org.junit.Test;

/**
 * @ClassName BeanFactoryTest
 * @Description
 * @DateTime 2020/1/19 9:06 下午
 * @Author yang
 */
public class BeanFactoryTest {
    private BeanFactory beanFactory;


    @Before
    /**
     * @Desc 创建bean工厂
     * @Param []
     * @Return void
     * @Throws
     * @Author yang
     * @Date 2020/1/19
     */
    public void creatBeanFactory() {
        beanFactory = new BeanFactory();
    }

    @Test
    /**
     * @Desc 测试
     * @Param []
     * @Return void
     * @Throws
     * @Author yang
     * @Date 2020/1/19
     */
    public void test() {
        //1.注册bean对象
        beanFactory.registryBeanDefinition("helloWorld", new BeanDefinition(new HelloWorld()));
        //2.获取bean对象
        HelloWorld helloWorld = (HelloWorld) beanFactory.getBean("helloWorld");
        //3.对象调用对象方法
        helloWorld.sayHello();
    }

}
