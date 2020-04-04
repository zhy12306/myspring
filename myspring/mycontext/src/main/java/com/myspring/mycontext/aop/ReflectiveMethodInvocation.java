package com.myspring.mycontext.aop;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: YANG
 * @Date: 2020/4/3 17:31
 * @Version: V1.0.0
 */
public class ReflectiveMethodInvocation implements MethodInvocation {
    private Object target;
    private Method method;
    private Object[] arg;

    public ReflectiveMethodInvocation(Object target, Method method, Object[] arg) {
        this.target = target;
        this.method = method;
        this.arg = arg;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return arg;
    }

    @Override
    public Object proceed() throws Throwable {
        return method.invoke(target,arg);
    }

    @Override
    public Object getThis() {
        return target;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return method;
    }
}
