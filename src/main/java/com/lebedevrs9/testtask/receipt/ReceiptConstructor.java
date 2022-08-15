package com.lebedevrs9.testtask.receipt;

import com.lebedevrs9.testtask.constructor.BelgiumBeerConstructor;
import com.lebedevrs9.testtask.constructor.BreadConstructor;
import com.lebedevrs9.testtask.constructor.DutchBeerConstructor;
import com.lebedevrs9.testtask.constructor.GermanBeerConstructor;
import com.lebedevrs9.testtask.constructor.LineItemConstructor;
import com.lebedevrs9.testtask.constructor.VegetableConstructor;
import com.lebedevrs9.testtask.lineitem.LineItem;
import com.lebedevrs9.testtask.lineitem.TotalLineItem;
import com.lebedevrs9.testtask.order.Order;
import com.lebedevrs9.testtask.product.Product;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public enum ReceiptConstructor {

    INSTANCE;

    private static final Map<Class<? extends Product>, LineItemConstructor> lineItemConstructorByType =
            Map.of(
                    VegetableConstructor.INSTANCE.getType(), VegetableConstructor.INSTANCE,
                    BreadConstructor.INSTANCE.getType(), BreadConstructor.INSTANCE,
                    BelgiumBeerConstructor.INSTANCE.getType(), BelgiumBeerConstructor.INSTANCE,
                    DutchBeerConstructor.INSTANCE.getType(), DutchBeerConstructor.INSTANCE,
                    GermanBeerConstructor.INSTANCE.getType(), GermanBeerConstructor.INSTANCE
            );


    public Receipt orderToReceipt(Order order) {
        Set<LineItem> lineItems = new HashSet<>();
        var productsByType =
                order.products()
                        .stream()
                        .collect(Collectors.groupingBy(Product::getClass));
        productsByType.forEach((k, v) ->
                lineItems.add(
                        lineItemConstructorByType.get(k).lineItem(v)
                )
        );
        double subTotal = lineItems.stream().mapToDouble(LineItem::getSubTotal).sum();
        double discount = lineItems.stream().mapToDouble(LineItem::getDiscount).sum();
        double total = lineItems.stream().mapToDouble(LineItem::getTotal).sum();
        TotalLineItem totalLineItem = new TotalLineItem(subTotal, discount, total);
        return new Receipt(order.id(), lineItems, totalLineItem);
    }

}
