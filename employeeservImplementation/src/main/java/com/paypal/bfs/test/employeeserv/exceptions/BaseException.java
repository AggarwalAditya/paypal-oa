package com.paypal.bfs.test.employeeserv.exceptions;

public class BaseException extends Exception {
    private Integer errorCode;

    public BaseException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
