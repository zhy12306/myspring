package com.myspring.mycontext.context;

import com.myspring.mycontext.aop.AbstractAopFactory;
import com.myspring.mycontext.bean.BeanPostProcessor;
import com.myspring.mycontext.bean.factory.AbstractBeanFactory;
import com.myspring.mycontext.exception.beanexception.BeanException;

import java.util.List;

/**
 * @Description: 抽象容器类
 * @Author: YANG
 * @Date: 2020/4/3 14:55
 * @Version: V1.0.0
 */
public abstract class AbstractApplicationContext implements ApplicationContext {
    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception {
        loadBeanDefinition(beanFactory);
        registerBeanPostProcessors(beanFactory);
        onRefresh();
    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }

    protected abstract void loadBeanDefinition(AbstractBeanFactory beanFactory) throws Exception;

    protected void registerBeanPostProcessors(AbstractBeanFactory beanFactory) throws Exception {
        List beanPostProcessors = beanFactory.getBeanByType(BeanPostProcessor.class);
        for (Object beanPostProcessor : beanPostProcessors) {
            beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
        }
    }

    protected void onRefresh() throws Exception {
        beanFactory.preInstantiateSingleLetons();
    }
}
