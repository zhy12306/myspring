package com.myspring.mycontext.bean;

/**
 * @Description: bean注入处理器
 * @Author: YANG
 * @Date: 2020/4/4 18:32
 * @Version: V1.0.0
 */
public interface BeanPostProcessor {
    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;

    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;

}
