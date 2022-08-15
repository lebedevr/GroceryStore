package com.lebedevrs9.testtask.receipt;

import com.lebedevrs9.testtask.lineitem.LineItem;
import com.lebedevrs9.testtask.lineitem.QuantityLineItem;
import com.lebedevrs9.testtask.lineitem.TotalLineItem;
import com.lebedevrs9.testtask.lineitem.WeightLineItem;
import com.lebedevrs9.testtask.unit.UnitService;

public enum ReceiptPrinter {

    INSTANCE;

    public void printReceipt(Receipt receipt) {
        System.out.println("Order №" + receipt.orderId());
        System.out.println("===============================================================================");
        System.out.println("| item            | price    | quant/weight | subtotal | discount | total     |");
        System.out.println("-------------------------------------------------------------------------------");
        for (LineItem lineItem : receipt.lineItems())
            printLineItem(lineItem);
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("                                             | subtotal | discount | total    |");
        System.out.println("-------------------------------------------------------------------------------");
        printTotalLineItem(receipt.totalLineItem());
        System.out.println("===============================================================================");
        System.out.println();
    }

    private void printLineItem(LineItem li) {
        if (li instanceof WeightLineItem) {
            String weightSign = UnitService.INSTANCE.weight().sign();
            System.out.printf(
                    "| %-15s | %-8.2f | %-10.3f %s | %-8.2f | %-8.2f | %-8.2f |\n",
                    li.getItem(), li.getPrice(), ((WeightLineItem) li).getWeight(), weightSign,
                    li.getSubTotal(), li.getDiscount(), li.getTotal()
            );
        }
        else if (li instanceof QuantityLineItem)
            System.out.printf(
                    "| %-15s | %-8.2f | %-13d | %-8.2f | %-8.2f | %-8.2f |\n",
                    li.getItem(), li.getPrice(), ((QuantityLineItem) li).getQuantity(),
                    li.getSubTotal(), li.getDiscount(), li.getTotal()
            );
    }

    private void printTotalLineItem(TotalLineItem tli) {
        String currencySign = UnitService.INSTANCE.currency().sign();
        System.out.printf(
                "                                             | %-8.2f | %-8.2f | %-6.2f %s |\n",
                tli.subTotal(), tli.discount(), tli.total(), currencySign
        );
    }
}
