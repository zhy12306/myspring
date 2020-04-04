package com.myspring.mycontext.exception.beanexception;

import com.myspring.mycontext.exception.beanexception.errorcode.BeanFoundErrorCode;

/**
 * @DateTime 2020/3/26 9:31 下午
 * @Author yang
 */
public class BeanNotFoundException extends BeanException {
    public BeanNotFoundException(String beanName) {
        super(BeanFoundErrorCode.BF001.getErrorCode(), BeanFoundErrorCode.BF001.getErrorMessage() + beanName + " is defined !");
    }

}
