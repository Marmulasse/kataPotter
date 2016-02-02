package com.arolla.katapotter;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class BasketTest {

    @Test
    public void should_return_prices_without_discount() {
        assertThat(new Basket(Arrays.asList()).price()).isEqualTo(0);
        assertThat(new Basket(Arrays.asList(0)).price()).isEqualTo(8);
        assertThat(new Basket(Arrays.asList(1)).price()).isEqualTo(8);
        assertThat(new Basket(Arrays.asList(2)).price()).isEqualTo(8);
        assertThat(new Basket(Arrays.asList(3)).price()).isEqualTo(8);
        assertThat(new Basket(Arrays.asList(4)).price()).isEqualTo(8);
        assertThat(new Basket(Arrays.asList(0, 0)).price()).isEqualTo(8 * 2);
        assertThat(new Basket(Arrays.asList(1, 1, 1)).price()).isEqualTo(8 * 3);
    }

    @Test
    public void should_return_prices_with_simple_discount() {
        assertThat(new Basket(Arrays.asList(0, 1)).price()).isEqualTo(8 * 2 * 0.95);
        assertThat(new Basket(Arrays.asList(0, 2, 4)).price()).isEqualTo(8 * 3 * 0.9);
        assertThat(new Basket(Arrays.asList(0, 1, 2, 4)).price()).isEqualTo(8 * 4 * 0.8);
        assertThat(new Basket(Arrays.asList(0, 1, 2, 3, 4)).price()).isEqualTo(8 * 5 * 0.75);
    }

    @Test
    public void should_return_several_discounts() {
        assertThat(new Basket(Arrays.asList(0, 0, 1)).price()).isEqualTo(8 + (8 * 2 * 0.95));
        assertThat(new Basket(Arrays.asList(0, 0, 1, 1)).price()).isEqualTo(2 * (8 * 2 * 0.95));
        assertThat(new Basket(Arrays.asList(0, 1, 1, 2, 3, 4)).price()).isEqualTo(8 + (8 * 5 * 0.75));
    }

    @Test
    public void should_return_edge_cases() {
        assertThat(new Basket(Arrays.asList(0, 0, 1, 1, 2, 2, 3, 4)).price()).isEqualTo(2 * (8 * 4 * 0.8));
        assertThat(new Basket(Arrays.asList(
                0, 0, 0, 0, 0,
                1, 1, 1, 1, 1,
                2, 2, 2, 2,
                3, 3, 3, 3, 3,
                4, 4, 4, 4)).price()).isEqualTo(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8));
    }

}