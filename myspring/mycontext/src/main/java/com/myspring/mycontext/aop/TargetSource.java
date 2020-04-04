package com.myspring.mycontext.aop;

/**
 * @Description: 被代理的对象
 * @Author: YANG
 * @Date: 2020/4/3 17:00
 * @Version: V1.0.0
 */
public class TargetSource {
    private Class targetClass;
    private Object target;

    public TargetSource(Class targetClass, Object target) {
        this.targetClass = targetClass;
        this.target = target;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class targetClass) {
        this.targetClass = targetClass;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
