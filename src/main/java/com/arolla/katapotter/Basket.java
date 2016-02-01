package com.arolla.katapotter;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by dpanza on 01/02/16.
 */
public class Basket {

    private final List<BookNumber> books;
    private static final Integer BOOK_PRICE = 8;


    public Basket(List<Integer> books) {
        this.books = books.stream()//
                .map(BookNumber::valueFromNumber)//
                .collect(Collectors.toList());
    }


    public double price() {
        return (books.size() * BOOK_PRICE) * new Discount(books).get();
    }
}
