package com.myspring.mycontext.aop;

/**
 * @Description:
 * @Author: YANG
 * @Date: 2020/4/4 14:44
 * @Version: V1.0.0
 */
public interface ClassFilter {
    boolean matches(Class targetClass);
}
