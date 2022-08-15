package com.lebedevrs9.testtask.constructor;

import com.lebedevrs9.testtask.product.BelgiumBeer;
import com.lebedevrs9.testtask.product.Product;

public enum BelgiumBeerConstructor implements BeerConstructor {

    INSTANCE;

    @Override
    public String label() {
        return "Belgium Beer";
    }

    @Override
    public double price() {
        return 10;
    }

    @Override
    public Class<? extends Product> getType() {
        return BelgiumBeer.class;
    }

    @Override
    public double discountPerPack() {
        return 3;
    }
}
