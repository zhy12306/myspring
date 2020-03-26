package com.myspring.mycontext.exception;

/**
 * @DateTime 2020/3/26 9:03 下午
 * @Author yang
 */
public enum BeanFoundErrorCode {
    BF001("BF001", "no bean named ");

    private String errorCode;
    private String errorMessage;


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
        return "BeanFoundErrorCode{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }

    private BeanFoundErrorCode(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
