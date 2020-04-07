package com.myspring.mycontext.bean.factory;

import com.myspring.mycontext.BeanReference;
import com.myspring.mycontext.aop.BeanFactoryAutoware;
import com.myspring.mycontext.bean.BeanDefinition;
import com.myspring.mycontext.bean.PropertyValue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName AutowireCapableBeanFactory
 * @Description
 * @DateTime 2020/1/20 4:14 下午
 * @Author yang
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    /**
     * 将属性集合中的属性注入到对象中
     *
     * @param bean
     * @param beanDefinition
     * @throws Exception
     */
    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        if (bean instanceof BeanFactoryAutoware) {
            ((BeanFactoryAutoware) bean).setBeanFactory(this);
        }
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            try {
                Method declaredMethod = bean.getClass().getDeclaredMethod("set" + propertyValue.getName().substring(0, 1).toUpperCase() + propertyValue.getName().substring(1), value.getClass());
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(bean, value);
            } catch (NoSuchMethodException e) {
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                declaredField.set(bean, value);
            }


        }
    }
}
