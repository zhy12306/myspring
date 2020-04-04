package com.myspring.mycontext.aop;

/**
 * @Description: 被代理的对象
 * @Author: YANG
 * @Date: 2020/4/3 17:00
 * @Version: V1.0.0
 */
public class TargetSource {
    private Class<?>[] targetClass;
    private Object target;

    public TargetSource(Object target, Class<?>... targetClass) {
        this.target = target;
        this.targetClass = targetClass;
    }

    public Class<?>[] getTargetClass() {
        return targetClass;
    }

    public Object getTarget() {
        return target;
    }
}
