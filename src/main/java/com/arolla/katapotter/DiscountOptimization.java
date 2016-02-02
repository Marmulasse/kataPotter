package com.arolla.katapotter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by dpanza on 02/02/16.
 */
public enum DiscountOptimization {
    TEN_AND_TWENTY_FIVE_TO_TWENTY_AND_TWENTY(
            (discounts) -> {
                long nbOfTwentyFiveDiscount = discounts.stream().filter(d -> d == Discount.TWENTY_FIVE_DISCOUNT).count();
                long nbOfTenDiscount = discounts.stream().filter(d -> d == Discount.TEN_DISCOUNT).count();
                return nbOfTenDiscount > 0 && nbOfTwentyFiveDiscount > 0;
            },
            (discounts) -> {
                discounts.remove(Discount.TWENTY_FIVE_DISCOUNT);
                discounts.remove(Discount.TEN_DISCOUNT);
                discounts.add(Discount.TWENTY_DISCOUNT);
                discounts.add(Discount.TWENTY_DISCOUNT);
                return discounts;
            });

    private final Predicate<List<Discount>> predicate;
    private final Function<List<Discount>, List<Discount>> action;

    DiscountOptimization(Predicate<List<Discount>> predicate, Function<List<Discount>, List<Discount>> action) {
        this.predicate = predicate;
        this.action = action;
    }

    public boolean available(List<Discount> discounts) {
        return this.predicate.test(discounts);
    }

    public List<Discount> apply(List<Discount> discounts) {
        return this.action.apply(new ArrayList<>(discounts));
    }
}
