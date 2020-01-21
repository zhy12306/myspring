package com.myspring.mycontext.factory;

import com.myspring.mycontext.BeanDefinition;
import com.myspring.mycontext.PropertyValue;
import com.myspring.mycontext.PropertyValues;
import com.myspring.mycontext.exception.BeanCreateErrorCode;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.lang.reflect.Field;
import java.util.List;

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
            applyPropertyValues(bean, beanDefinition);
            return bean;
        } catch (Exception e) {
            logger.error(BeanCreateErrorCode.BC003.getErrorCode() + "," + BeanCreateErrorCode.BC003.getErrorMessage() + beanDefinition.getBeanClassName() + "失败！", e);
        }
        return null;
    }

    private void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        List<PropertyValue> propertyValueList = beanDefinition.getPropertyValues().getPropertyValues();
        long startTime = System.currentTimeMillis();
        System.out.println("开始为 bean 对象设置属性：" + startTime);
        for (PropertyValue propertyValue : propertyValueList) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            declaredField.set(bean, propertyValue.getValue());
            long l1 = System.currentTimeMillis();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("结束 bean 对象属性设置：" + endTime);
        System.out.println("bean对象赋值总耗时：" + (endTime - startTime));
    }
}
