package com.myspring.mycontext.context;

import com.myspring.mycontext.bean.factory.AbstractBeanFactory;
import com.myspring.mycontext.exception.beanexception.BeanException;

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
    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
