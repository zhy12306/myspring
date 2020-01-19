package com.myspring.mycontext;

/**
 * @ClassName BeanDefinition
 * @Description 实例定义
 * @DateTime 2020/1/19 8:34 下午
 * @Author yang
 */
public class BeanDefinition {
    private Object bean;

    public  BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
