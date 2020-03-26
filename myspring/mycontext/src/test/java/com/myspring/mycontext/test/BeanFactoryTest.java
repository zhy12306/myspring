package com.myspring.mycontext.test;

import com.myspring.mycontext.BeanDefinition;
import com.myspring.mycontext.factory.AutowireCapableBeanFactory;
import com.myspring.mycontext.factory.BeanFactory;
import com.myspring.mycontext.io.ResourceLoader;
import com.myspring.mycontext.xml.XmlBeanDefinitionReader;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

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
        //1.注册bean对象
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition("myspringcontextIOC.xml");
        Set<Map.Entry<String, BeanDefinition>> beanSet = xmlBeanDefinitionReader.getRegistry().entrySet();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : beanSet) {
            String key = beanDefinitionEntry.getKey();
            BeanDefinition beanDefinition = beanDefinitionEntry.getValue();
            beanFactory.registryBeanDefinition(key, beanDefinition);
        }
        //2.获取bean对象
        HelloWorld helloWorld = (HelloWorld) beanFactory.getBean("helloWorld");
        //3.对象调用对象方法
        helloWorld.sayHello();
    }
}
