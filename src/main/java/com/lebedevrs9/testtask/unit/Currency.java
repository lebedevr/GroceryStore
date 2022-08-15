package com.lebedevrs9.testtask.unit;

public enum Currency {
    USD("$"), EUR("€"), GBP("£");

    private final String sign;

    Currency(String sign) {
        this.sign = sign;
    }

    public String sign() {
        return sign;
    }
}
