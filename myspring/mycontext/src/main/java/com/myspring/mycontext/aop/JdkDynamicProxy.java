package com.myspring.mycontext.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: 基于jdk的动态代理
 * @Author: YANG
 * @Date: 2020/4/3 17:14
 * @Version: V1.0.0
 */
public class JdkDynamicProxy implements AopProxy, InvocationHandler {
    private AdvicedSupport advicedSupport;

    public JdkDynamicProxy(AdvicedSupport advicedSupport) {
        this.advicedSupport = advicedSupport;
    }

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{advicedSupport.getTargetSource().getTargetClass()}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodInterceptor methodInterceptor = advicedSupport.getMethodInterceptor();
        return methodInterceptor.invoke(new ReflectiveMethodInvocation(advicedSupport.getTargetSource().getTarget(), method, args));
    }
}
