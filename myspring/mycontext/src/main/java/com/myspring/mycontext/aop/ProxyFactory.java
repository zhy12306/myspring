package com.myspring.mycontext.aop;

/**
 * @Description: 代理工厂类
 * @Author: YANG
 * @Date: 2020/4/4 22:27
 * @Version: V1.0.0
 */
public class ProxyFactory extends  AdvisedSupport implements AopProxy {

    @Override
    public Object getProxy() {
        return createAopProxy().getProxy() ;
    }

    protected final  AopProxy createAopProxy(){
        return new Cglib2AopProxy(this);
    }
}
