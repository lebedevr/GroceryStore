package com.lebedevrs9.testtask.constructor;

import com.lebedevrs9.testtask.lineitem.LineItem;
import com.lebedevrs9.testtask.product.Product;

import java.util.List;

public interface LineItemConstructor {
    String label();
    double price();
    Class<? extends Product> getType();
    LineItem lineItem(List<Product> products);
}
