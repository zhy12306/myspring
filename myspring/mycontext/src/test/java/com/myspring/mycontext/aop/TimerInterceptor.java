package com.myspring.mycontext.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Description: 拦截器类
 * @Author: YANG
 * @Date: 2020/4/3 17:58
 * @Version: V1.0.0
 */
public class TimerInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long time = System.currentTimeMillis();
        System.out.println("Invocation of method " + invocation.getMethod().getName() + " start ！");
        Object proceed = invocation.proceed();
        System.out.println("Invocation of method " + invocation.getMethod().getName() + " end ！takes " + (System.nanoTime() - time) + " seconds !");
        return proceed;
    }
}
