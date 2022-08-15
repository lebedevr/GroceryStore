package com.lebedevrs9.testtask.product;

import com.lebedevrs9.testtask.product.Bread;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BreadValidationTest {

    @Test
    void validBreadDays() {
        new Bread(3);
    }

    @Test
    void invalidBreadDays() {
        assertThrows(IllegalArgumentException.class, () -> new Bread(7));
    }
}
