package com.lebedevrs9.testtask.product;

public class Bread extends Product {

    private final int days;

    public Bread(int days) {
        if (days > 6)
            throw new IllegalArgumentException("Breads older than 6 days cannot be added to orders.");
        this.days = days;
    }

    public int days() {
        return days;
    }

}
