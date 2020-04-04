package com.myspring.mycontext.aop;

/**
 * @Description:
 * @Author: YANG
 * @Date: 2020/4/4 14:43
 * @Version: V1.0.0
 */
public interface Pointcut {
    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

}
