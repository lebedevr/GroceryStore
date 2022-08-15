package com.lebedevrs9.testtask.order;

import com.lebedevrs9.testtask.product.Product;

import java.util.List;

public record Order(long id, List<Product> products) {

}
