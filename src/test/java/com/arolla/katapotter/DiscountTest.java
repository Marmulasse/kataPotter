package com.arolla.katapotter;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by dpanza on 01/02/16.
 */
public class DiscountTest {


    @Test
    public void should_return_discount_for_no_books(){
        List<BookNumber> books = Arrays.asList();
        assertThat(new Discount(books).get()).isEqualTo(1.0);
    }

    @Test
    public void should_return_discount_for_one_book(){
        List<BookNumber> books = Arrays.asList(BookNumber.FIRST);
        assertThat(new Discount(books).get()).isEqualTo(1.0);
    }

    @Test
    public void should_return_discount_for_two_same_books(){
        List<BookNumber> books = Arrays.asList(BookNumber.FIRST, BookNumber.FIRST);
        assertThat(new Discount(books).get()).isEqualTo(1.0);
    }

    @Test
    public void should_return_discount_for_two_different_books(){
        List<BookNumber> books = Arrays.asList(BookNumber.FIRST, BookNumber.SECOND);
        assertThat(new Discount(books).get()).isEqualTo(0.95);
    }

    @Test
    public void should_return_discount_for_three_different_books(){
        List<BookNumber> books = Arrays.asList(BookNumber.FIRST, BookNumber.SECOND, BookNumber.THIRD);
        assertThat(new Discount(books).get()).isEqualTo(0.9);
    }

    @Test
    public void should_return_discount_for_four_different_books(){
        List<BookNumber> books = Arrays.asList(BookNumber.SECOND, BookNumber.THIRD, BookNumber.FOURTH, BookNumber.FIFTH);
        assertThat(new Discount(books).get()).isEqualTo(0.8);
    }

    @Test
    public void should_return_discount_for_full_series(){
        List<BookNumber> books = Arrays.asList(BookNumber.SECOND, BookNumber.THIRD, BookNumber.FOURTH, BookNumber.FIFTH, BookNumber.FIRST);
        assertThat(new Discount(books).get()).isEqualTo(0.75);
    }

    @Test
    public void should_return_discount_for_full_series_plus_one_other_book(){
        List<BookNumber> books = Arrays.asList(BookNumber.SECOND, BookNumber.SECOND, BookNumber.THIRD, BookNumber.FOURTH, BookNumber.FIFTH, BookNumber.FIRST);
        assertThat(new Discount(books).get()).isEqualTo(0.75);
    }
}
