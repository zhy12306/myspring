package com.myspring.mycontext.factory;

import com.myspring.mycontext.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName BeanFactory
 * @Description
 * @DateTime 2020/1/19 8:43 下午
 * @Author yang
 */
public abstract class AbstractBeanFactory implements BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    /**
     * @Desc 将对象注册到beanfactory中
     * @Param [name, beanDefinition]
     * @Return void
     * @Throws
     * @Author yang
     * @Date 2020/1/20
     */
    public void registryBeanDefinition(String name, BeanDefinition beanDefinition) {
        Object bean = doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
        beanDefinitionMap.put(name, beanDefinition);
    }

    @Override
    /**
     * @Desc 根据对象名获取bean对象
     * @Param [name]
     * @Return java.lang.Object
     * @Throws
     * @Author yang
     * @Date 2020/1/20
     */
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    /**
     * @Desc   初始化bean
     * @Author yang
     * @Date   2020/1/20
    */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition);

}