package com.myspring.mycontext.bean;

import java.io.IOException;

/**
 * @DateTime 2020/1/21 4:58 下午
 * @Author yang
 */
public interface BeanDefinitionReader {
    void loadBeanDefinitions(String location) throws Exception;
}
