package com.myspring.mycontext.factory;

import com.myspring.mycontext.BeanDefinition;

/**
 * @ClassName BeanFactory
 * @Description
 * @DateTime 2020/1/20 2:36 下午
 * @Author yang
 */
public interface BeanFactory {
    /**
     * @Desc   将bean对象注册到bean工厂中
     * @Author yang
     * @Date   2020/1/20
    */
     void registryBeanDefinition(String name, BeanDefinition beanDefinition);
     
    /**
     * @Desc   根据对象名获取bean对象
     * @Author yang
     * @Date   2020/1/20
    */
     Object getBean(String name);
}
