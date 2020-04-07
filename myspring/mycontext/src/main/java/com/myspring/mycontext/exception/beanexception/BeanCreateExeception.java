package com.myspring.mycontext.exception.beanexception;

import com.myspring.mycontext.exception.beanexception.errorcode.BeanCreateErrorCode;

/**
 * @Description: bean实例创建失败
 * @Author: YANG
 * @Date: 2020/4/4 22:47
 * @Version: V1.0.0
 */
public class BeanCreateExeception extends BeanException {
    public BeanCreateExeception(String beanName) {
        super(BeanCreateErrorCode.BC004.getErrorCode(),BeanCreateErrorCode.BC004.getErrorMessage()+beanName+"' must specify a ref or value");
    }
}
