package com.bank.perevod.exception;

public class CanNotCreateSource extends RuntimeException {

    public CanNotCreateSource() {
        super();
    }
    public CanNotCreateSource(String message) {
        super(message);
    }
    public CanNotCreateSource(Exception e) {
        super(e);
    }
    public CanNotCreateSource(String message,Exception e) {
        super(message,e);
    }
}
