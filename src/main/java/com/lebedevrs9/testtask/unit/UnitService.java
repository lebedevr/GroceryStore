package com.lebedevrs9.testtask.unit;

public enum UnitService {

    INSTANCE;

    public Weight weight() {
        return Weight.KG;
    }

    public Currency currency() {
        return Currency.EUR;
    }
}
