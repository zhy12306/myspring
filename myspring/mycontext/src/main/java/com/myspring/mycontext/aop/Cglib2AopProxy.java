package com.myspring.mycontext.aop;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description: cglib代理
 * @Author: YANG
 * @Date: 2020/4/4 21:48
 * @Version: V1.0.0
 */
public class Cglib2AopProxy extends AbstractAopFactory {


    public Cglib2AopProxy(AdvisedSupport advicedSupport) {
        super(advicedSupport);
    }

    @Override
    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(advicedSupport.getTargetSource().getTargetClass());
        enhancer.setInterfaces(advicedSupport.getTargetSource().getInterfaces());
        enhancer.setCallback(new DynamicAdvisedInterceptor(advicedSupport));
        Object enhanced = enhancer.create();
        return enhanced;
    }

    private static class DynamicAdvisedInterceptor implements MethodInterceptor {
        private AdvisedSupport advisedSupport;
        private org.aopalliance.intercept.MethodInterceptor delegateMethodInterceptor;

        private DynamicAdvisedInterceptor(AdvisedSupport advisedSupport) {
            this.advisedSupport = advisedSupport;
            this.delegateMethodInterceptor = advisedSupport.getMethodInterceptor();
        }


        @Override
        public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            if (advisedSupport.getMethodMatcher() == null || advisedSupport.getMethodMatcher().matches(method, advisedSupport.getTargetSource().getTargetClass())) {
                return delegateMethodInterceptor.invoke(new CglibMethodInvocation(advisedSupport.getTargetSource().getTarget(), method, args, methodProxy));
            }
            return new CglibMethodInvocation(advisedSupport.getTargetSource().getTarget(), method, args, methodProxy).proceed();
        }
    }

    private static class CglibMethodInvocation extends ReflectiveMethodInvocation {
        private final MethodProxy methodProxy;

        public CglibMethodInvocation(Object target, Method method, Object[] arg, MethodProxy methodProxy) {
            super(target, method, arg);
            this.methodProxy = methodProxy;
        }

        @Override
        public Object proceed() throws Throwable {
            return this.methodProxy.invoke(this.target, this.arg);
        }
    }

}
