package com.myspring.mycontext.aop;

/**
 * @Description: 切点通知接口
 * @Author: YANG
 * @Date: 2020/4/4 14:52
 * @Version: V1.0.0
 */
public interface PointcutAdvisor extends Advisor {
    Pointcut getPointcut();
}
