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
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {

    private AdvicedSupport advicedSupport;

    public JdkDynamicAopProxy(AdvicedSupport advicedSupport) {
        this.advicedSupport = advicedSupport;
    }

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(), advicedSupport.getTargetSource().getTargetClass(), this);
    }

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
        MethodInterceptor methodInterceptor = advicedSupport.getMethodInterceptor();
        if (advicedSupport.getMethodMatcher() != null && advicedSupport.getMethodMatcher().matches(method, advicedSupport.getTargetSource().getTarget().getClass())) {
            return methodInterceptor.invoke(new ReflectiveMethodInvocation(advicedSupport.getTargetSource().getTarget(), method, args));
        }else {
            return method.invoke(advicedSupport.getTargetSource().getTarget(),args);
        }
    }
}
