package com.myspring.mycontext;

import jdk.nashorn.internal.ir.CallNode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName BeanFactory
 * @Description
 * @DateTime 2020/1/19 8:43 下午
 * @Author yang
 */
public class BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public void registryBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }

    public Object getBean(String name){
        return beanDefinitionMap.get(name).getBean();
    }
}
