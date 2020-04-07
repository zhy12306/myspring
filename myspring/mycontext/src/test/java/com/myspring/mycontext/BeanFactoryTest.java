package com.myspring.mycontext;

import com.myspring.mycontext.bean.BeanDefinition;
import com.myspring.mycontext.bean.factory.AbstractBeanFactory;
import com.myspring.mycontext.bean.factory.AutowireCapableBeanFactory;
import com.myspring.mycontext.bean.factory.BeanFactory;
import com.myspring.mycontext.bean.io.ResourceLoader;
import com.myspring.mycontext.bean.xml.XmlBeanDefinitionReader;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

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
     * @Author yang
     * @Date 2020/1/19
     */
    public void test() throws Exception {
        //1.读取bean  xml配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("myspringcontextIOC.xml");

        //2初始化beanfactory，并注入bean
        AutowireCapableBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        //3.获取bean对象
        HelloWorldServiceImp helloWorld = (HelloWorldServiceImp) beanFactory.getBean("helloWorld");
        //3.对象调用对象方法
        helloWorld.sayHello();
    }

    @Test
    public void testPreInstantiate() throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("myspringcontextIOC.xml");

        // 2.初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3.初始化bean
        beanFactory.preInstantiateSingleLetons();

        // 4.获取bean
        HelloWorldServiceImp helloWorld = (HelloWorldServiceImp) beanFactory.getBean("helloWorld");
        //5.对象调用对象方法
        helloWorld.sayHello();
    }


}
