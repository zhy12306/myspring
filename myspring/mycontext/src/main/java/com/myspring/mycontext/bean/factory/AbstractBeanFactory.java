package com.myspring.mycontext.bean.factory;

import com.myspring.mycontext.bean.BeanDefinition;
import com.myspring.mycontext.exception.beanexception.BeanException;
import com.myspring.mycontext.exception.beanexception.BeanNotFoundException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    private final List<String> beanDdefinitionName = new ArrayList<>();

    /**
     * @Desc 将对象注册到beanfactory中
     * @Param [name, beanDefinition]
     * @Return void
     * @Author yang
     * @Date 2020/1/20
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        Object bean = doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
        beanDefinitionMap.put(name, beanDefinition);
        beanDdefinitionName.add(name);
    }

    public void preInstantiateSingleLetons() throws BeanException {
        for (Iterator<String> iterator = this.beanDdefinitionName.iterator(); iterator.hasNext(); ) {
            String beanName = iterator.next();
            getBean(beanName);
        }
    }

    @Override
    /**
     * @Desc 根据对象名获取bean对象
     * @Param [name]
     * @Return java.lang.Object
     * @Author yang
     * @Date 2020/1/20
     */
    public Object getBean(String name) throws BeanException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new BeanNotFoundException(name);
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreateBean(beanDefinition);
        }
        return bean;

    }

    /**
     * @Desc 初始化bean
     * @Author yang
     * @Date 2020/1/20
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition);

}
