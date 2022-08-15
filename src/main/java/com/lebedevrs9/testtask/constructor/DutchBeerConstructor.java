package com.lebedevrs9.testtask.constructor;

import com.lebedevrs9.testtask.product.DutchBeer;
import com.lebedevrs9.testtask.product.Product;

public enum DutchBeerConstructor implements BeerConstructor {

    INSTANCE;

    @Override
    public String label() {
        return "Dutch Beer";
    }

    @Override
    public double price() {
        return 20;
    }

    @Override
    public Class<? extends Product> getType() {
        return DutchBeer.class;
    }

    @Override
    public double discountPerPack() {
        return 2;
    }
}
