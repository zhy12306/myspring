package com.myspring.mycontext.exception.beanexception.errorcode;

/**
 * @className BeanCreateErrorCode
 * @description
 * @date 2020/1/20 3:31 下午
 * @author yang
 */
public enum BeanCreateErrorCode {
    BC001("BC0001", "类名格式错误，创建bean对象："),
    BC002("BC002", "类名解析失败，创建bean对象："),
    BC003("BC003", "创建bean对象：");

    private String errorCode;
    private String errorMessage;


    private BeanCreateErrorCode(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "BeanCreateErrorCode{" +
                "errorCode='" + this.errorCode + '\'' +
                ", errorMessage='" + this.errorMessage + '\'' +
                '}';
    }
}
