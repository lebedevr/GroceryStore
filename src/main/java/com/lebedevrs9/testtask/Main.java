package com.lebedevrs9.testtask;

import com.lebedevrs9.testtask.order.Order;
import com.lebedevrs9.testtask.product.BelgiumBeer;
import com.lebedevrs9.testtask.product.Bread;
import com.lebedevrs9.testtask.product.DutchBeer;
import com.lebedevrs9.testtask.product.GermanBeer;
import com.lebedevrs9.testtask.product.Product;
import com.lebedevrs9.testtask.product.Vegetables;
import com.lebedevrs9.testtask.receipt.Receipt;
import com.lebedevrs9.testtask.receipt.ReceiptConstructor;
import com.lebedevrs9.testtask.receipt.ReceiptPrinter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Order order1 = createOrder1();
        Order order2 = createOrder2();
        Order order3 = createOrder3();
        Receipt receipt1 = ReceiptConstructor.INSTANCE.orderToReceipt(order1);
        Receipt receipt2 = ReceiptConstructor.INSTANCE.orderToReceipt(order2);
        Receipt receipt3 = ReceiptConstructor.INSTANCE.orderToReceipt(order3);
        ReceiptPrinter.INSTANCE.printReceipt(receipt1);
        ReceiptPrinter.INSTANCE.printReceipt(receipt2);
        ReceiptPrinter.INSTANCE.printReceipt(receipt3);
    }

    private static Order createOrder1() {
        List<Product> products = List.of(
                new Bread(0),
                new Bread(1),

                new Bread(3),
                new Bread(3),
                new Bread(4),
                new Bread(5),

                new Bread(6),
                new Bread(6),
                new Bread(6),

                new BelgiumBeer(),
                new BelgiumBeer(),
                new BelgiumBeer(),
                new BelgiumBeer(),
                new BelgiumBeer(),
                new BelgiumBeer(),

                new Vegetables(0.100)
        );
        return new Order(1L, products);
    }

    private static Order createOrder2() {
        List<Product> products = List.of(
                new BelgiumBeer(),

                new DutchBeer(),
                new DutchBeer(),
                new DutchBeer(),
                new DutchBeer(),
                new DutchBeer(),
                new DutchBeer(),
                new DutchBeer(),

                new GermanBeer(),

                new Vegetables(0.100),
                new Vegetables(0.200)
        );
        return new Order(2L, products);
    }

    private static Order createOrder3() {
        List<Product> products = List.of(
                new DutchBeer(),

                new GermanBeer(),
                new GermanBeer(),
                new GermanBeer(),
                new GermanBeer(),
                new GermanBeer(),
                new GermanBeer(),
                new GermanBeer(),
                new GermanBeer(),

                new Vegetables(0.100),
                new Vegetables(0.200),
                new Vegetables(0.300)
        );
        return new Order(3L, products);
    }

}
