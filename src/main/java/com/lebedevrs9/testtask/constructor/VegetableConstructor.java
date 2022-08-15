package com.lebedevrs9.testtask.constructor;

import com.lebedevrs9.testtask.lineitem.LineItem;
import com.lebedevrs9.testtask.lineitem.WeightLineItem;
import com.lebedevrs9.testtask.product.Product;
import com.lebedevrs9.testtask.product.Vegetables;

import java.math.BigDecimal;
import java.util.List;

public enum VegetableConstructor implements LineItemConstructor {

    INSTANCE;

    @Override
    public String label() {
        return "Vegetables";
    }

    @Override
    public double price() {
        return 10;
    }

    @Override
    public Class<? extends Product> getType() {
        return Vegetables.class;
    }

    @Override
    public LineItem lineItem(List<Product> products) {
        BigDecimal weight = BigDecimal.ZERO;
        for (Product p : products)
            weight = weight.add(new BigDecimal(String.valueOf(((Vegetables)p).getWeight())));
        BigDecimal subTotal = weight.multiply(new BigDecimal(String.valueOf(price())));
        BigDecimal total;
        if (weight.doubleValue() <= 0.100) total = subTotal.multiply(new BigDecimal(String.valueOf(0.95)));
        else if (weight.doubleValue() <= 0.500) total = subTotal.multiply(new BigDecimal(String.valueOf(0.93)));
        else total = subTotal.multiply(new BigDecimal(String.valueOf(0.9)));
        BigDecimal discount = subTotal.subtract(total);
        return new WeightLineItem(label(), price(), weight.doubleValue(),
                subTotal.doubleValue(), discount.doubleValue(), total.doubleValue());
    }

}
