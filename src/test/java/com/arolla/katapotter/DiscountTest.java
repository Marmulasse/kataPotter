package com.arolla.katapotter;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DiscountTest {

    @Test
    public void should_return_discount_for_no_books() {
        assertThat(Discount.fromSizeOfSeries(0)).isNull();
    }

    @Test
    public void should_return_discount_for_one_type() {
        assertThat(Discount.fromSizeOfSeries(1)).isEqualTo(Discount.NO_DISCOUNT);
    }

    @Test
    public void should_return_discount_for_two_different_books() {
        assertThat(Discount.fromSizeOfSeries(2)).isEqualTo(Discount.FIVE_DISCOUNT);
    }

    @Test
    public void should_return_discount_for_three_different_books() {
        assertThat(Discount.fromSizeOfSeries(3)).isEqualTo(Discount.TEN_DISCOUNT);
    }

    @Test
    public void should_return_discount_for_four_different_books() {
        assertThat(Discount.fromSizeOfSeries(4)).isEqualTo(Discount.TWENTY_DISCOUNT);
    }

    @Test
    public void should_return_discount_for_full_series() {
        assertThat(Discount.fromSizeOfSeries(5)).isEqualTo(Discount.TWENTY_FIVE_DISCOUNT);
    }

}