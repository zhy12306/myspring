package com.myspring.mycontext.aop;

/**
 * @Description: 抽象Aop工厂
 * @Author: YANG
 * @Date: 2020/4/4 21:29
 * @Version: V1.0.0
 */
public abstract class AbstractAopFactory implements AopProxy {
    protected AdvisedSupport advicedSupport;

    public AbstractAopFactory(AdvisedSupport advicedSupport) {
        this.advicedSupport = advicedSupport;
    }
}
