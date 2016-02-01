package com.arolla.katapotter;

import java.util.List;

/**
 * Created by dpanza on 01/02/16.
 */
public class Discount {

    private enum DiscountValue {
        NO_DISCOUNT(0, 1), FIVE_DISCOUNT(2, 0.95), TEN_DISCOUNT(3, 0.9), TWENTY_DISCOUNT(4, 0.8), TWENTY_FIVE_DISCOUNT(5, 0.75);

        private final long differentType;
        private final double discountValue;

        DiscountValue(long differentType, double discountValue) {
            this.differentType = differentType;
            this.discountValue = discountValue;
        }

        public double getValue() {
            return discountValue;
        }

        public static DiscountValue getDiscountValueFromTypes(long differentType){
            for (DiscountValue discountValue : values()) {
                if(discountValue.differentType == differentType){
                    return discountValue;
                }
            }

            return NO_DISCOUNT;
        }
    }

    private final List<BookNumber> books;

    public Discount(List<BookNumber> books) {
        this.books = books;
    }

    public Double get() {
        long differentBooks = books.stream()//
                .distinct()//
                .count();
        return DiscountValue.getDiscountValueFromTypes(differentBooks).getValue();
    }
}
