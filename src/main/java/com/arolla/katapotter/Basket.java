package com.arolla.katapotter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by dpanza on 01/02/16.
 */
public class Basket {

    private static final double BOOK_PRICE = 8.0;
    private static final double DEFAULT_PRICE = 0.0;
    private final List<BookNumber> books;


    public Basket(List<Integer> books) {
        this.books = books.stream()//
                .map(BookNumber::valueFromNumber)//
                .collect(Collectors.toList());
    }

    public double price() {
        return accumulateSeries(DEFAULT_PRICE, new ArrayList<>(books));
    }

    public double accumulateSeries(double price, List<BookNumber> booksLeft){
        Set<BookNumber> series = getSeries(booksLeft);
        series.forEach(booksLeft::remove);
        if(hasSeries(booksLeft)){
            price = accumulateSeries(price, booksLeft);
        }
        return addPrice(price, series);
    }

    private double addPrice(double price, Set<BookNumber> series) {
        price += series.size() * BOOK_PRICE * DiscountValue.getDiscountValueFromTypes(series.size()).getValue();
        return price;
    }

    private boolean hasSeries(List<BookNumber> booksLeft) {
        return getSeries(booksLeft).size() > 0;
    }

    private Set<BookNumber> getSeries(List<BookNumber> booksLeft) {
        return new HashSet<>(booksLeft);
    }
}
