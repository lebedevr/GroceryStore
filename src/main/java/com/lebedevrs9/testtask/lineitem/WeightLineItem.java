package com.lebedevrs9.testtask.lineitem;

import java.util.Objects;

public class WeightLineItem extends LineItem {

    private final double weight;

    public WeightLineItem(String item, double price, double weight, double subTotal, double discount, double total) {
        super(item, price, subTotal, discount, total);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeightLineItem)) return false;
        if (!super.equals(o)) return false;
        WeightLineItem that = (WeightLineItem) o;
        return Double.compare(that.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight);
    }

    @Override
    public String toString() {
        return "WeightLineItem{" +
                "weight=" + weight +
                "} " + super.toString();
    }
}
