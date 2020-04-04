package com.myspring.mycontext.aop;

import com.myspring.mycontext.bean.factory.BeanFactory;

/**
 * @Description: 工厂自动注入类
 * @Author: YANG
 * @Date: 2020/4/4 18:30
 * @Version: V1.0.0
 */
public interface BeanFactoryAutoware {
    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
