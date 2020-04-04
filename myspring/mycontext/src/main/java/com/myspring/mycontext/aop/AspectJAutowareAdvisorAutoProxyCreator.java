package com.myspring.mycontext.aop;

import com.myspring.mycontext.bean.BeanPostProcessor;
import com.myspring.mycontext.bean.factory.AbstractBeanFactory;
import com.myspring.mycontext.bean.factory.BeanFactory;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.List;

/**
 * @Description: 自动注入切面动态代理创建类
 * @Author: YANG
 * @Date: 2020/4/4 18:28
 * @Version: V1.0.0
 */
public class AspectJAutowareAdvisorAutoProxyCreator implements BeanFactoryAutoware, BeanPostProcessor {
    private AbstractBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws Exception {
        this.beanFactory= (AbstractBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        if (bean instanceof AspectJExpressionPointcutAdvisor){
            return bean;
        }
        if ( bean instanceof MethodInterceptor){
            return bean;
        }
        List<AspectJExpressionPointcutAdvisor> advisors=beanFactory.getBeanByType(AspectJExpressionPointcutAdvisor.class);
        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            if (advisor.getPointCut().getClassFilter().matches(bean.getClass())){
                AdvicedSupport advicedSupport = new AdvicedSupport();
                advicedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
                advicedSupport.setMethodMatcher(advisor.getPointCut().getMethodMatcher());

                TargetSource targetSource = new TargetSource(bean, bean.getClass().getInterfaces());
                advicedSupport.setTargetSource(targetSource);
                return  new JdkDynamicAopProxy(advicedSupport).getProxy();
            }
        }
        return bean;
    }
}
