package com.bank.perevod.exception;

public class UnauthorizedException extends Exception {

    public UnauthorizedException() {
    }

    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException(String message, Throwable t) {
        super(message, t);
    }
}
