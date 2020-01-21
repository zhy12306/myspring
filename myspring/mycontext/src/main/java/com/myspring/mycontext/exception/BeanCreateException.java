package com.myspring.mycontext.exception;

/**
 * @ClassName BeanCreateException
 * @Description
 * @DateTime 2020/1/20 3:02 下午
 * @Author yang
 */
public class BeanCreateException extends Exception {
    private String errorCode;
    private String showeMessage;
    private Throwable cause;

    public BeanCreateException() {
    }

    public BeanCreateException(String errorMessage) {
        super(errorMessage);
    }

    public BeanCreateException(Throwable cause) {
        super(cause);
        this.cause = cause;
    }

    public BeanCreateException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BeanCreateException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.cause = cause;
    }


    public BeanCreateException(String errorCode, String errorMessage, Throwable cause) {
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
