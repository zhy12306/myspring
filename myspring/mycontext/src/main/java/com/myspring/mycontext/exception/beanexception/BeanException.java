package com.myspring.mycontext.exception.beanexception;

/**
 * @ClassName BeanCreateException
 * @Description
 * @DateTime 2020/1/20 3:02 下午
 * @Author yang
 */
public abstract class BeanException extends Exception {
    private String errorCode;
    private String showeMessage;
    private Throwable cause;

    public BeanException() {
    }

    public BeanException(String errorMessage) {
        super(errorMessage);
    }

    public BeanException(Throwable cause) {
        super(cause);
        this.cause = cause;
    }

    public BeanException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BeanException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.cause = cause;
    }


    public BeanException(String errorCode, String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.errorCode = errorCode;
        this.cause = cause;
    }

    @Override
    public String getMessage() {
        String message = super.getMessage();
        String causeMsg = null;
        if (this.cause != null) {
            causeMsg = this.cause.getMessage();
        }
        if (message != null) {
            return causeMsg != null ? message + " caused by " + causeMsg : message;
        } else {
            return message;
        }
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setShoweMessage(String showeMessage) {
        this.showeMessage = showeMessage;
    }

    public String getShoweMessage() {
        return this.showeMessage == null ? super.getMessage() : this.showeMessage;
    }
}
