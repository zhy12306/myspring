package com.myspring.mycontext.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * @Description: 代理相关的元数据
 * @Author: YANG
 * @Date: 2020/4/3 16:59
 * @Version: V1.0.0
 */
public class AdvicedSupport {
    private TargetSource targetSource;
    private MethodInterceptor methodInterceptor;

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }
}
