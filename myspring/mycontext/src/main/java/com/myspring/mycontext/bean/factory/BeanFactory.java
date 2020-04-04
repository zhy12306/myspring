package com.myspring.mycontext.bean.factory;

import com.myspring.mycontext.exception.beanexception.BeanException;

/**
 * @ClassName BeanFactory
 * @Description
 * @DateTime 2020/1/20 2:36 下午
 * @Author yang
 */
public interface BeanFactory {
    /**
     * @Desc 根据对象名获取bean对象
     * @Author yang
     * @Date 2020/1/20
     */
    Object getBean(String name) throws Exception;
}
