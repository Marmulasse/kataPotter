package com.arolla.katapotter;

import java.util.Optional;

/**
* Created by dpanza on 01/02/16.
*/
enum Discount {
    NO_DISCOUNT(1, 1),
    FIVE_DISCOUNT(2, 0.95),
    TEN_DISCOUNT(3, 0.9),
    TWENTY_DISCOUNT(4, 0.8),
    TWENTY_FIVE_DISCOUNT(5, 0.75);

    private final long seriesSize;
    private final double discountValue;

    Discount(long seriesSize, double discountValue) {
        this.seriesSize = seriesSize;
        this.discountValue = discountValue;
    }

    public long getSeriesSize(){
        return seriesSize;
    }

    public double getValue() {
        return discountValue;
    }

    public static Optional<Discount> fromSizeOfSeries(long sizeOfSeries){
        for (Discount discount : values()) {
            if(discount.seriesSize == sizeOfSeries){
                return Optional.of(discount);
            }
        }
        return Optional.empty();
    }
}
