package com.myspring.mycontext.aop;

import org.aopalliance.aop.Advice;

/**
 * @Description: 切点通知类
 * @Author: YANG
 * @Date: 2020/4/4 14:50
 * @Version: V1.0.0
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {
    private AspectJExpressionPointcut pointCut = new AspectJExpressionPointcut();
    private Advice advice;

    public void setExpression(String expression){
        this.pointCut.setExpression(expression);
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Pointcut getPointcut() {
        return pointCut;
    }
}
