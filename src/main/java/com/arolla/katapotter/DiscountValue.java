package com.arolla.katapotter;

import java.util.function.Predicate;

/**
* Created by dpanza on 01/02/16.
*/
enum DiscountValue {
    NO_DISCOUNT((n) -> n < 2, 1),
    FIVE_DISCOUNT((n) -> n == 2, 0.95),
    TEN_DISCOUNT((n) -> n == 3, 0.9),
    TWENTY_DISCOUNT((n) -> n == 4, 0.8),
    TWENTY_FIVE_DISCOUNT((n) -> n > 4, 0.75);

    private final Predicate<Long> predicate;
    private final double discountValue;

    DiscountValue(Predicate<Long> predicate, double discountValue) {
        this.predicate = predicate;
        this.discountValue = discountValue;
    }

    public double getValue() {
        return discountValue;
    }

    public static DiscountValue getDiscountValueFromTypes(long differentType){
        for (DiscountValue discountValue : values()) {
            if(discountValue.predicate.test(differentType)){
                return discountValue;
            }
        }

        return NO_DISCOUNT;
    }
}
