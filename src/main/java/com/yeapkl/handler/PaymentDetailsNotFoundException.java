package com.yeapkl.handler;

public class PaymentDetailsNotFoundException extends RuntimeException {

    public PaymentDetailsNotFoundException(String text) {
        super(text);
    }
}
