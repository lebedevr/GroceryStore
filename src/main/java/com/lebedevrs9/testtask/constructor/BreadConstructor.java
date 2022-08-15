package com.lebedevrs9.testtask.constructor;

import com.lebedevrs9.testtask.lineitem.LineItem;
import com.lebedevrs9.testtask.lineitem.QuantityLineItem;
import com.lebedevrs9.testtask.product.Bread;
import com.lebedevrs9.testtask.product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public enum BreadConstructor implements LineItemConstructor {

    INSTANCE;

    @Override
    public String label() {
        return "Bread";
    }

    @Override
    public double price() {
        return 20;
    }

    @Override
    public Class<? extends Product> getType() {
        return Bread.class;
    }

    @Override
    public LineItem lineItem(List<Product> products) {
        List<Bread> breads = new ArrayList<>();
        for (Product p : products)
            breads.add((Bread)p);
        long newBread = breads.stream().filter(b -> b.days() <= 2).count();
        long threeDayOld = breads.stream().filter(b -> b.days() >= 3 && b.days() <= 5).count();
        long sixDayOld = breads.stream().filter(b -> b.days() == 6).count();
        long paymentAmount = 0;
        paymentAmount += newBread;
        paymentAmount += threeDayOld / 2;
        paymentAmount += threeDayOld % 2;
        paymentAmount += sixDayOld / 3;
        paymentAmount += (sixDayOld % 3) >= 1 ? 1 : 0;
        int quantity = breads.size();
        BigDecimal subTotal = new BigDecimal(String.valueOf(price())).multiply(new BigDecimal(breads.size()));
        BigDecimal total = new BigDecimal(String.valueOf(price())).multiply(new BigDecimal(paymentAmount));
        BigDecimal discount = subTotal.subtract(total);
        return new QuantityLineItem(label(), price(), quantity, subTotal.doubleValue(),
                discount.doubleValue(), total.doubleValue());
    }
}
