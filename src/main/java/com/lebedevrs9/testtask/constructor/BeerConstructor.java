package com.lebedevrs9.testtask.constructor;

import com.lebedevrs9.testtask.lineitem.LineItem;
import com.lebedevrs9.testtask.lineitem.QuantityLineItem;
import com.lebedevrs9.testtask.product.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public interface BeerConstructor extends LineItemConstructor {
    @Override
    default LineItem lineItem(List<Product> products) {
        BigDecimal quantity = new BigDecimal(products.size());
        BigDecimal subTotal = quantity.multiply(new BigDecimal(String.valueOf(price())));
        BigDecimal discount = quantity.divide(BigDecimal.valueOf(6), RoundingMode.DOWN)
                .multiply(BigDecimal.valueOf(discountPerPack()));
        BigDecimal total = subTotal.subtract(discount);
        return new QuantityLineItem(label(), price(), quantity.intValue(),
                subTotal.doubleValue(), discount.doubleValue(), total.doubleValue());
    }

    double discountPerPack();
}
