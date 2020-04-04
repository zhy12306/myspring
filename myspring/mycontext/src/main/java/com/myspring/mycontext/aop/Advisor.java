package com.myspring.mycontext.aop;

import org.aopalliance.aop.Advice;

/**
 * @Description: 通知类
 * @Author: YANG
 * @Date: 2020/4/4 14:38
 * @Version: V1.0.0
 */
public interface Advisor {
    Advice getAdvice();
}
