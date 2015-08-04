package com.ebay.tracking.skunkworks.searchapi.exception;

/**
 * @author chrysan
 */
public class BadParamException extends RuntimeException {

    public BadParamException() {
        super();    //To change body of overridden methods use File | Settings | File Templates.
    }

    public BadParamException(String s) {
        super(s);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public BadParamException(String s, Throwable throwable) {
        super(s, throwable);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public BadParamException(Throwable throwable) {
        super(throwable);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
