package com.arolla.katapotter;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DiscountValueTest {

    @Test
    public void should_return_discount_for_no_books() {
        assertThat(DiscountValue.getDiscountValueFromTypes(0)).isEqualTo(DiscountValue.NO_DISCOUNT);
    }

    @Test
    public void should_return_discount_for_one_type() {
        assertThat(DiscountValue.getDiscountValueFromTypes(1)).isEqualTo(DiscountValue.NO_DISCOUNT);
    }

    @Test
    public void should_return_discount_for_two_different_books() {
        assertThat(DiscountValue.getDiscountValueFromTypes(2)).isEqualTo(DiscountValue.FIVE_DISCOUNT);
    }

    @Test
    public void should_return_discount_for_three_different_books() {
        assertThat(DiscountValue.getDiscountValueFromTypes(3)).isEqualTo(DiscountValue.TEN_DISCOUNT);
    }

    @Test
    public void should_return_discount_for_four_different_books() {
        assertThat(DiscountValue.getDiscountValueFromTypes(4)).isEqualTo(DiscountValue.TWENTY_DISCOUNT);
    }

    @Test
    public void should_return_discount_for_full_series() {
        assertThat(DiscountValue.getDiscountValueFromTypes(5)).isEqualTo(DiscountValue.TWENTY_FIVE_DISCOUNT);
    }

    @Test
    public void should_return_discount_for_full_series_plus_one_other_book() {
        assertThat(DiscountValue.getDiscountValueFromTypes(6)).isEqualTo(DiscountValue.TWENTY_FIVE_DISCOUNT);
    }
}