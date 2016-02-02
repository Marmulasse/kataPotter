package com.arolla.katapotter;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DiscountOptimizationTest {

    @Test
    public void should_be_available() throws Exception {
        assertThat(DiscountOptimization.TEN_AND_TWENTY_FIVE_TO_TWENTY_AND_TWENTY.available(Arrays.asList(Discount.TWENTY_FIVE_DISCOUNT, Discount.TEN_DISCOUNT))).isTrue();
        assertThat(DiscountOptimization.TEN_AND_TWENTY_FIVE_TO_TWENTY_AND_TWENTY.available(Arrays.asList(Discount.TWENTY_FIVE_DISCOUNT, Discount.TEN_DISCOUNT, Discount.TWENTY_FIVE_DISCOUNT, Discount.TEN_DISCOUNT))).isTrue();
        assertThat(DiscountOptimization.TEN_AND_TWENTY_FIVE_TO_TWENTY_AND_TWENTY.available(Arrays.asList(Discount.TWENTY_FIVE_DISCOUNT, Discount.TEN_DISCOUNT, Discount.NO_DISCOUNT))).isTrue();
    }

    @Test
    public void should_not_be_available() throws Exception {
        assertThat(DiscountOptimization.TEN_AND_TWENTY_FIVE_TO_TWENTY_AND_TWENTY.available(Arrays.asList())).isFalse();
        assertThat(DiscountOptimization.TEN_AND_TWENTY_FIVE_TO_TWENTY_AND_TWENTY.available(Arrays.asList(Discount.NO_DISCOUNT))).isFalse();
        assertThat(DiscountOptimization.TEN_AND_TWENTY_FIVE_TO_TWENTY_AND_TWENTY.available(Arrays.asList(Discount.FIVE_DISCOUNT, Discount.FIVE_DISCOUNT))).isFalse();
        assertThat(DiscountOptimization.TEN_AND_TWENTY_FIVE_TO_TWENTY_AND_TWENTY.available(Arrays.asList(Discount.TEN_DISCOUNT, Discount.TEN_DISCOUNT))).isFalse();
    }

    @Test
    public void should_apply_optimization() throws Exception {
        List<Discount> optimizedDiscounts = DiscountOptimization.TEN_AND_TWENTY_FIVE_TO_TWENTY_AND_TWENTY.apply(Arrays.asList(Discount.TWENTY_FIVE_DISCOUNT, Discount.TEN_DISCOUNT));

        assertThat(optimizedDiscounts).containsExactly(Discount.TWENTY_DISCOUNT, Discount.TWENTY_DISCOUNT);
    }
}