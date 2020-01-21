package com.myspring.mycontext;

import com.myspring.mycontext.exception.BeanCreateErrorCode;
import com.myspring.mycontext.exception.BeanCreateException;

/**
 * @ClassName BeanDefinition
 * @Description bean的内容及元数据，保存在BeanFactory中，包装bean的实体
 * @DateTime 2020/1/19 8:34 下午
 * @Author yang
 */
public class BeanDefinition {
    private Object bean;
    private Class beanClass;
    private String beanClassName;
    private  PropertyValues propertyValues;

    public BeanDefinition() {

    }

    public Object getBean() {
        return bean;
    }

    public BeanDefinition setBean(Object bean) {
        this.bean = bean;
        return this;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public BeanDefinition setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
        return this;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public BeanDefinition setBeanClassName(String beanClassName) throws BeanCreateException {
        if (beanClassName == null || beanClassName.trim().length() == 0) {
            throw new BeanCreateException(BeanCreateErrorCode.BC001.getErrorCode(), BeanCreateErrorCode.BC001.getErrorMessage() + beanClassName + "失败！");
        }
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            throw new BeanCreateException(BeanCreateErrorCode.BC002.getErrorCode(), BeanCreateErrorCode.BC002.getErrorMessage() + beanClassName + "失败！", e);
        }
        return this;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public BeanDefinition setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
        return this;
    }
}
