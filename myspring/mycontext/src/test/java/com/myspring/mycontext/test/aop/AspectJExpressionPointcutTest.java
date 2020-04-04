package com.myspring.mycontext.test.aop;

import com.myspring.mycontext.aop.AspectJExpressionPointcut;
import com.myspring.mycontext.test.HelloWorld;
import com.myspring.mycontext.test.HelloWorldService;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Description: 切面測試類
 * @Author: YANG
 * @Date: 2020/4/4 16:38
 * @Version: V1.0.0
 */
public class AspectJExpressionPointcutTest {
    @Test
    public void testClassFilter() {
        String expression = "execution(* com.myspring.mycontext.test.*.*(..)) ";
        AspectJExpressionPointcut aspectJExpressionPointCut = new AspectJExpressionPointcut();
        aspectJExpressionPointCut.setExpression(expression);
        boolean matches = aspectJExpressionPointCut.getClassFilter().matches(HelloWorldService.class);
        Assert.assertTrue(matches);
    }

    @Test
    public void testMethodInterceptor() throws NoSuchMethodException {
        String expression = "execution(* com.myspring.mycontext.test.*.*(..)) ";
        AspectJExpressionPointcut aspectJExpressionPointCut = new AspectJExpressionPointcut();
        aspectJExpressionPointCut.setExpression(expression);
        boolean sayHello = aspectJExpressionPointCut.getMethodMatcher().matches(HelloWorld.class.getDeclaredMethod("sayHello"), HelloWorld.class);
        Assert.assertTrue(sayHello);

    }

}
