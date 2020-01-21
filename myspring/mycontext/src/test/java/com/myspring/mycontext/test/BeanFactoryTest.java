package com.myspring.mycontext.test;

import com.myspring.mycontext.BeanDefinition;
import com.myspring.mycontext.exception.BeanCreateException;
import com.myspring.mycontext.factory.AbstractBeanFactory;
import com.myspring.mycontext.factory.AutowireCapableBeanFactory;
import com.myspring.mycontext.factory.BeanFactory;
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
     * @Desc 初始化创建bean工厂
     * @Param []
     * @Return void
     * @Throws
     * @Author yang
     * @Date 2020/1/19
     */
    public void creatBeanFactory() {
        beanFactory = new AutowireCapableBeanFactory();
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
        try {
            beanFactory.registryBeanDefinition("helloWorld", new BeanDefinition().setBeanClassName("com.myspring.mycontext.test.HelloWorld"));
        } catch (BeanCreateException e) {
            e.printStackTrace();
        }
        //2.获取bean对象
        HelloWorld helloWorld = (HelloWorld) beanFactory.getBean("helloWorld");
        //3.对象调用对象方法
        helloWorld.sayHello();
    }
}
