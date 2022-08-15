package com.lebedevrs9.testtask.lineitem;

import java.util.Objects;

public class QuantityLineItem extends LineItem {

    private final int quantity;

    public QuantityLineItem(String item, double price, int quantity, double subTotal, double discount, double total) {
        super(item, price, subTotal, discount, total);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuantityLineItem)) return false;
        if (!super.equals(o)) return false;
        QuantityLineItem that = (QuantityLineItem) o;
        return quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), quantity);
    }

    @Override
    public String toString() {
        return "QuantityLineItem{" +
                "quantity=" + quantity +
                "} " + super.toString();
    }
}
