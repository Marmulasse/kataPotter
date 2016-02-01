package com.arolla.katapotter;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class BasketTest {

    @Test
    public void should_return_prices_without_discount(){
        assertThat(new Basket(Arrays.asList()).price()).isEqualTo(0);
        assertThat(new Basket(Arrays.asList(0)).price()).isEqualTo(8);
        assertThat(new Basket(Arrays.asList(1)).price()).isEqualTo(8);
        assertThat(new Basket(Arrays.asList(2)).price()).isEqualTo(8);
        assertThat(new Basket(Arrays.asList(3)).price()).isEqualTo(8);
        assertThat(new Basket(Arrays.asList(4)).price()).isEqualTo(8);
        assertThat(new Basket(Arrays.asList(0, 0)).price()).isEqualTo(8 * 2);
        assertThat(new Basket(Arrays.asList(1, 1, 1)).price()).isEqualTo(8 * 3);
    }

}