package com.myspring.mycontext.bean.factory;

import com.myspring.mycontext.bean.BeanDefinition;
import com.myspring.mycontext.BeanReference;
import com.myspring.mycontext.bean.PropertyValue;
import com.myspring.mycontext.exception.beanexception.errorcode.BeanCreateErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

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
            Object bean = createBeanInstance(beanDefinition);
            beanDefinition.setBean(bean);
            applyPropertyValues(bean, beanDefinition);
            return bean;
        } catch (Exception e) {
            logger.error(BeanCreateErrorCode.BC003.getErrorCode() + "," + BeanCreateErrorCode.BC003.getErrorMessage() + beanDefinition.getBeanClassName() + "失败！", e);
        }
        return null;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();

    }

    /**
     * 将属性集合中的属性注入到对象中
     *
     * @param bean
     * @param beanDefinition
     * @throws Exception
     */
    private void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference){
                BeanReference beanReference= (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            declaredField.set(bean, propertyValue.getValue());
        }
    }
}