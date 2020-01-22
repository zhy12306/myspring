package com.myspring.mycontext;

import com.myspring.mycontext.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * 从配置文件中读取BeanDefinition 配置
 *
 * @DateTime 2020/1/21 4:43 下午
 * @Author yang
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{
    private Map<String, BeanDefinition> registry;
    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<String, BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
