package com.lebedevrs9.testtask.receipt;

import com.lebedevrs9.testtask.lineitem.LineItem;
import com.lebedevrs9.testtask.lineitem.TotalLineItem;

import java.util.Set;

public record Receipt(long orderId, Set<LineItem> lineItems, TotalLineItem totalLineItem) {
}
