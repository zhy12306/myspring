package com.myspring.mycontext.factory;

import com.myspring.mycontext.BeanDefinition;
import com.myspring.mycontext.exception.BeanCreateErrorCode;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

/**
 * @ClassName AutowireCapableBeanFactory
 * @Description
 * @DateTime 2020/1/20 4:14 下午
 * @Author yang
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        Logger logger = LoggerFactory.getLogger(AutowireCapableBeanFactory.class);
        try {
            Object bean = beanDefinition.getBeanClass().newInstance();
            return bean;
        } catch (Exception e) {
            logger.error(BeanCreateErrorCode.BC003.getErrorCode()+","+BeanCreateErrorCode.BC003.getErrorMessage()+beanDefinition.getBeanClassName()+"失败！", e);
        }
        return null;
    }
}
