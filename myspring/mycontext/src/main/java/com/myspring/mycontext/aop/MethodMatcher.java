package com.myspring.mycontext.aop;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: YANG
 * @Date: 2020/4/4 14:44
 * @Version: V1.0.0
 */
public interface MethodMatcher {
    boolean matches(Method method, Class targetClass);

}
