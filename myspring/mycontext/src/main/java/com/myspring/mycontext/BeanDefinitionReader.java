package com.myspring.mycontext;

import java.io.IOException;

/**
 * @DateTime 2020/1/21 4:58 下午
 * @Author yang
 */
public interface BeanDefinitionReader {
    void loadBeanDefinition(String location) throws Exception;
}
