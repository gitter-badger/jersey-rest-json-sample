package com.ebay.tracking.skunkworks.searchapi.exception;

/**
 * @author chrysan
 */
public class InternalServiceErrorException extends RuntimeException {

    public InternalServiceErrorException() {
        super();    //To change body of overridden methods use File | Settings | File Templates.
    }

    public InternalServiceErrorException(String s) {
        super(s);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public InternalServiceErrorException(String s, Throwable throwable) {
        super(s, throwable);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public InternalServiceErrorException(Throwable throwable) {
        super(throwable);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
