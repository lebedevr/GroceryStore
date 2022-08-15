package com.lebedevrs9.testtask.receipt;

import com.lebedevrs9.testtask.constructor.BelgiumBeerConstructor;
import com.lebedevrs9.testtask.constructor.BreadConstructor;
import com.lebedevrs9.testtask.constructor.DutchBeerConstructor;
import com.lebedevrs9.testtask.constructor.GermanBeerConstructor;
import com.lebedevrs9.testtask.constructor.VegetableConstructor;
import com.lebedevrs9.testtask.lineitem.QuantityLineItem;
import com.lebedevrs9.testtask.lineitem.TotalLineItem;
import com.lebedevrs9.testtask.lineitem.WeightLineItem;
import com.lebedevrs9.testtask.order.Order;
import com.lebedevrs9.testtask.product.BelgiumBeer;
import com.lebedevrs9.testtask.product.Bread;
import com.lebedevrs9.testtask.product.DutchBeer;
import com.lebedevrs9.testtask.product.GermanBeer;
import com.lebedevrs9.testtask.product.Vegetables;
import com.lebedevrs9.testtask.receipt.Receipt;
import com.lebedevrs9.testtask.receipt.ReceiptConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class ReceiptConstructorTest {

    @ParameterizedTest
    @MethodSource({
            "vegetablesArguments",
            "breadsArguments",
            "beersArguments",
            "mixedArguments",
    })
    void constructReceipt(Order order, Receipt excepted) {
        Receipt actual = ReceiptConstructor.INSTANCE.orderToReceipt(order);
        Assertions.assertEquals(excepted, actual);
    }

    private static Stream<Arguments> vegetablesArguments() {
        return Stream.of(
                Arguments.of(
                        new Order(
                                1L,
                                List.of(
                                        new Vegetables(0.1)
                                )
                        ),
                        new Receipt(
                                1L,
                                Set.of(
                                        new WeightLineItem(
                                                VegetableConstructor.INSTANCE.label(),
                                                VegetableConstructor.INSTANCE.price(),
                                                0.1,
                                                1.0, 0.05, 0.95
                                        )
                                ),
                                new TotalLineItem(1.0, 0.05, 0.95)
                        )
                ),
                Arguments.of(
                        new Order(
                                2L,
                                List.of(
                                        new Vegetables(0.1),
                                        new Vegetables(0.2)
                                )
                        ),
                        new Receipt(
                                2L,
                                Set.of(
                                        new WeightLineItem(
                                                VegetableConstructor.INSTANCE.label(),
                                                VegetableConstructor.INSTANCE.price(),
                                                0.3,
                                                3.0, 0.21, 2.79
                                        )
                                ),
                                new TotalLineItem(3.0, 0.21, 2.79)
                        )
                ),
                Arguments.of(
                        new Order(
                                3L,
                                List.of(
                                        new Vegetables(0.1),
                                        new Vegetables(0.2),
                                        new Vegetables(0.3)
                                )
                        ),
                        new Receipt(
                                3L,
                                Set.of(
                                        new WeightLineItem(
                                                VegetableConstructor.INSTANCE.label(),
                                                VegetableConstructor.INSTANCE.price(),
                                                0.6,
                                                6.0, 0.6, 5.4
                                        )
                                ),
                                new TotalLineItem(6.0, 0.6, 5.4)
                        )
                )
        );
    }

    private static Stream<Arguments> breadsArguments() {
        return Stream.of(
                Arguments.of(
                        new Order(
                                4L,
                                List.of(
                                        new Bread(0),
                                        new Bread(0),
                                        new Bread(0)
                                )
                        ),
                        new Receipt(
                                4L,
                                Set.of(
                                        new QuantityLineItem(
                                                BreadConstructor.INSTANCE.label(),
                                                BreadConstructor.INSTANCE.price(),
                                                3,
                                                60.0, 0, 60.0
                                        )
                                ),
                                new TotalLineItem(60.0, 0, 60.0)
                        )
                ),
                Arguments.of(
                        new Order(
                                5L,
                                List.of(
                                        new Bread(0),
                                        new Bread(0),
                                        new Bread(0),
                                        new Bread(3),
                                        new Bread(3)
                                )
                        ),
                        new Receipt(
                                5L,
                                Set.of(
                                        new QuantityLineItem(
                                                BreadConstructor.INSTANCE.label(),
                                                BreadConstructor.INSTANCE.price(),
                                                5,
                                                100.0, 20.0, 80.0
                                        )
                                ),
                                new TotalLineItem(100.0, 20.0, 80.0)
                        )
                ),
                Arguments.of(
                        new Order(
                                6L,
                                List.of(
                                        new Bread(0),
                                        new Bread(0),
                                        new Bread(0),
                                        new Bread(3),
                                        new Bread(3),
                                        new Bread(6),
                                        new Bread(6)
                                )
                        ),
                        new Receipt(
                                6L,
                                Set.of(
                                        new QuantityLineItem(
                                                BreadConstructor.INSTANCE.label(),
                                                BreadConstructor.INSTANCE.price(),
                                                7,
                                                140.0, 40.0, 100.0
                                        )
                                ),
                                new TotalLineItem(140.0, 40.0, 100.0)
                        )
                ),
                Arguments.of(
                        new Order(
                                7L,
                                List.of(
                                        new Bread(0),
                                        new Bread(0),
                                        new Bread(0),
                                        new Bread(3),
                                        new Bread(3),
                                        new Bread(6),
                                        new Bread(6),
                                        new Bread(6)
                                )
                        ),
                        new Receipt(
                                7L,
                                Set.of(
                                        new QuantityLineItem(
                                                BreadConstructor.INSTANCE.label(),
                                                BreadConstructor.INSTANCE.price(),
                                                8,
                                                160.0, 60.0, 100.0
                                        )
                                ),
                                new TotalLineItem(160.0, 60.0, 100.0)
                        )
                ),
                Arguments.of(
                        new Order(
                                8L,
                                List.of(
                                        new Bread(0),
                                        new Bread(0),
                                        new Bread(0),
                                        new Bread(3),
                                        new Bread(3),
                                        new Bread(6),
                                        new Bread(6),
                                        new Bread(6),
                                        new Bread(6)
                                )
                        ),
                        new Receipt(
                                8L,
                                Set.of(
                                        new QuantityLineItem(
                                                BreadConstructor.INSTANCE.label(),
                                                BreadConstructor.INSTANCE.price(),
                                                9,
                                                180.0, 60.0, 120.0
                                        )
                                ),
                                new TotalLineItem(180.0, 60.0, 120.0)
                        )
                )
        );
    }

    private static Stream<Arguments> beersArguments() {
        return Stream.of(
                Arguments.of(
                        new Order(
                                9L,
                                List.of(
                                        new BelgiumBeer(),
                                        new BelgiumBeer(),
                                        new BelgiumBeer(),
                                        new BelgiumBeer(),
                                        new BelgiumBeer()
                                )
                        ),
                        new Receipt(
                                9L,
                                Set.of(
                                        new QuantityLineItem(
                                                BelgiumBeerConstructor.INSTANCE.label(),
                                                BelgiumBeerConstructor.INSTANCE.price(),
                                                5,
                                                50.0, 0, 50.0
                                        )
                                ),
                                new TotalLineItem(50.0, 0, 50.0)
                        )
                ),
                Arguments.of(
                        new Order(
                                10L,
                                List.of(
                                        new BelgiumBeer(),
                                        new BelgiumBeer(),
                                        new BelgiumBeer(),
                                        new BelgiumBeer(),
                                        new BelgiumBeer(),
                                        new BelgiumBeer()
                                )
                        ),
                        new Receipt(
                                10L,
                                Set.of(
                                        new QuantityLineItem(
                                                BelgiumBeerConstructor.INSTANCE.label(),
                                                BelgiumBeerConstructor.INSTANCE.price(),
                                                6,
                                                60.0, 3.0, 57.0
                                        )
                                ),
                                new TotalLineItem(60.0, 3.0, 57.0)
                        )
                ),
                Arguments.of(
                        new Order(
                                11L,
                                List.of(
                                        new GermanBeer(),
                                        new GermanBeer(),
                                        new GermanBeer(),
                                        new GermanBeer(),
                                        new GermanBeer(),
                                        new GermanBeer()
                                )
                        ),
                        new Receipt(
                                11L,
                                Set.of(
                                        new QuantityLineItem(
                                                GermanBeerConstructor.INSTANCE.label(),
                                                GermanBeerConstructor.INSTANCE.price(),
                                                6,
                                                90.0, 3.0, 87.0
                                        )
                                ),
                                new TotalLineItem(90.0, 3.0, 87.0)
                        )
                ),
                Arguments.of(
                        new Order(
                                12L,
                                List.of(
                                        new DutchBeer(),
                                        new DutchBeer(),
                                        new DutchBeer(),
                                        new DutchBeer(),
                                        new DutchBeer(),
                                        new DutchBeer()
                                )
                        ),
                        new Receipt(
                                12L,
                                Set.of(
                                        new QuantityLineItem(
                                                DutchBeerConstructor.INSTANCE.label(),
                                                DutchBeerConstructor.INSTANCE.price(),
                                                6,
                                                120.0, 2.0, 118.0
                                        )
                                ),
                                new TotalLineItem(120.0, 2.0, 118.0)
                        )
                )
        );
    }

    private static Stream<Arguments> mixedArguments() {
        return Stream.of(
                Arguments.of(
                        new Order(
                                13L,
                                List.of(
                                        new Bread(0),
                                        new DutchBeer(),
                                        new Vegetables(0.1)
                                )
                        ),
                        new Receipt(
                                13L,
                                Set.of(
                                        new QuantityLineItem(
                                                BreadConstructor.INSTANCE.label(),
                                                BreadConstructor.INSTANCE.price(),
                                                1,
                                                20.0, 0, 20.0
                                        ),
                                        new QuantityLineItem(
                                                DutchBeerConstructor.INSTANCE.label(),
                                                DutchBeerConstructor.INSTANCE.price(),
                                                1,
                                                20.0, 0, 20.0
                                        ),
                                        new WeightLineItem(
                                                VegetableConstructor.INSTANCE.label(),
                                                VegetableConstructor.INSTANCE.price(),
                                                0.1,
                                                1.0, 0.05, 0.95
                                        )
                                ),
                                new TotalLineItem(41.0, 0.05, 40.95)
                        )
                ),
                Arguments.of(
                        new Order(
                                14L,
                                List.of(
                                        new Bread(0),
                                        new Bread(0),
                                        new Bread(0),
                                        new Bread(3),
                                        new Bread(3),
                                        new Bread(6),
                                        new Bread(6),
                                        new Bread(6),
                                        new Bread(6),
                                        new GermanBeer(),
                                        new GermanBeer(),
                                        new GermanBeer(),
                                        new GermanBeer(),
                                        new GermanBeer(),
                                        new GermanBeer(),
                                        new BelgiumBeer(),
                                        new BelgiumBeer(),
                                        new BelgiumBeer(),
                                        new BelgiumBeer(),
                                        new BelgiumBeer(),
                                        new BelgiumBeer(),
                                        new DutchBeer(),
                                        new DutchBeer(),
                                        new DutchBeer(),
                                        new DutchBeer(),
                                        new DutchBeer(),
                                        new DutchBeer(),
                                        new Vegetables(0.1),
                                        new Vegetables(0.2),
                                        new Vegetables(0.3)
                                )
                        ),
                        new Receipt(
                                14L,
                                Set.of(
                                        new QuantityLineItem(
                                                BreadConstructor.INSTANCE.label(),
                                                BreadConstructor.INSTANCE.price(),
                                                9,
                                                180.0, 60.0, 120.0
                                        ),
                                        new QuantityLineItem(
                                                GermanBeerConstructor.INSTANCE.label(),
                                                GermanBeerConstructor.INSTANCE.price(),
                                                6,
                                                90.0, 3.0, 87.0
                                        ),
                                        new QuantityLineItem(
                                                BelgiumBeerConstructor.INSTANCE.label(),
                                                BelgiumBeerConstructor.INSTANCE.price(),
                                                6,
                                                60.0, 3.0, 57.0
                                        ),
                                        new QuantityLineItem(
                                                DutchBeerConstructor.INSTANCE.label(),
                                                DutchBeerConstructor.INSTANCE.price(),
                                                6,
                                                120.0, 2.0, 118.0
                                        ),
                                        new WeightLineItem(
                                                VegetableConstructor.INSTANCE.label(),
                                                VegetableConstructor.INSTANCE.price(),
                                                0.6,
                                                6.0, 0.6, 5.4
                                        )
                                ),
                                new TotalLineItem(456.0, 68.6, 387.4)
                        )
                )
        );
    }
}
