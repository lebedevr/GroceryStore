package com.lebedevrs9.testtask.constructor;

import com.lebedevrs9.testtask.product.GermanBeer;
import com.lebedevrs9.testtask.product.Product;

public enum GermanBeerConstructor implements BeerConstructor {

    INSTANCE;
    @Override
    public String label() {
        return "German Beer";
    }

    @Override
    public double price() {
        return 15;
    }

    @Override
    public Class<? extends Product> getType() {
        return GermanBeer.class;
    }

    @Override
    public double discountPerPack() {
        return 3;
    }
}
