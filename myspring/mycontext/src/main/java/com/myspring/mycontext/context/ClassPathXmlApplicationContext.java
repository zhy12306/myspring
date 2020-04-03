package com.myspring.mycontext.context;

import com.myspring.mycontext.bean.BeanDefinition;
import com.myspring.mycontext.bean.factory.AbstractBeanFactory;
import com.myspring.mycontext.bean.factory.AutowireCapableBeanFactory;
import com.myspring.mycontext.bean.io.ResourceLoader;
import com.myspring.mycontext.bean.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @Description: xml路径应用容器
 * @Author: YANG
 * @Date: 2020/4/3 15:09
 * @Version: V1.0.0
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {
    private String configLocation;

    public ClassPathXmlApplicationContext(AbstractBeanFactory beanFactory, String configLocation) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(new AutowireCapableBeanFactory(), configLocation);
    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }

}
