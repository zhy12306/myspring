package com.myspring.mycontext.bean.factory;

import com.myspring.mycontext.bean.BeanDefinition;
import com.myspring.mycontext.bean.BeanPostProcessor;
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
    private final List<String> beanDefinitionNames = new ArrayList<>();
    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    /**
     * @Desc 将对象注册到beanfactory中
     * @Param [name, beanDefinition]
     * @Return void
     * @Author yang
     * @Date 2020/1/20
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }


    /**
     * @Description: 创建单例
     * @Param: []
     * @return: void
     * @Author: YANG
     * @Date: 2020/4/4 19:45
     **/
    public void preInstantiateSingleLetons() throws Exception {
        for (Iterator<String> iterator = this.beanDefinitionNames.iterator(); iterator.hasNext(); ) {
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
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new BeanNotFoundException(name);
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreateBean(beanDefinition);
            bean=initializeBean(bean,name);
            beanDefinition.setBean(bean);
        }
        return bean;

    }

    protected Object initializeBean(Object bean, String name) throws Exception {
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessBeforeInitialization(bean, name);
        }
        //TODO:call initialize method
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessAfterInitialization(bean, name);
        }
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }


    /**
     * @Desc 初始化bean
     * @Author yang
     * @Date 2020/1/20
     */
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
    }

    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List getBeanByType(Class type) throws Exception {
        List beans = new ArrayList<>();
        for (String beanDefinitionName : beanDefinitionNames) {
            if (type.isAssignableFrom(beanDefinitionMap.get(beanDefinitionName).getBeanClass())) {
                beans.add(getBean(beanDefinitionName));
            }
        }
        return beans;
    }
}
