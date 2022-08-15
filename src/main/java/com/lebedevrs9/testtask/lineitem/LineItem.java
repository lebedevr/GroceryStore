package com.lebedevrs9.testtask.lineitem;

import java.util.Objects;

public abstract class LineItem {
    private final String item;
    private final double price;
    private final double subTotal;
    private final double discount;
    private final double total;

    public LineItem(String item, double price, double subTotal, double discount, double total) {
        this.item = item;
        this.price = price;
        this.subTotal = subTotal;
        this.discount = discount;
        this.total = total;
    }

    public String getItem() {
        return item;
    }

    public double getPrice() {
        return price;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LineItem)) return false;
        LineItem lineItem = (LineItem) o;
        return Double.compare(lineItem.price, price) == 0 &&
                Double.compare(lineItem.subTotal, subTotal) == 0 &&
                Double.compare(lineItem.discount, discount) == 0 &&
                Double.compare(lineItem.total, total) == 0 &&
                Objects.equals(item, lineItem.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, price, subTotal, discount, total);
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "item='" + item + '\'' +
                ", price=" + price +
                ", subTotal=" + subTotal +
                ", discount=" + discount +
                ", total=" + total +
                '}';
    }
}
