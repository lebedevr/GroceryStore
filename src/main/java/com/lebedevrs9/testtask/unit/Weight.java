package com.lebedevrs9.testtask.unit;

public enum Weight {
    KG("kg"), LB("lb"), OZ("oz");

    private final String sign;

    Weight(String sign) {
        this.sign = sign;
    }

    public String sign() {
        return sign;
    }
}
