package com.arolla.katapotter;

import java.util.*;
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
        if(books.isEmpty()){
            return DEFAULT_PRICE;
        }

        List<Discount> discounts = accumulateDiscounts(new ArrayList<>(), new ArrayList<>(books));

       DiscountOptimization discountOptimization = DiscountOptimization.get();
       while(discountOptimization.available(discounts)){
            discounts = discountOptimization.apply(discounts);
        }

        return discounts.stream()
                .map(this::calculatePrice)
                .reduce(DEFAULT_PRICE, (total, price) -> total += price);
    }

    private double calculatePrice(Discount d) {
        return d.getSeriesSize() * BOOK_PRICE * d.getValue();
    }


    public List<Discount> accumulateDiscounts(final List<Discount> discounts, final List<BookNumber> booksLeft){
        Set<BookNumber> series = new HashSet<>(booksLeft);
        series.forEach(booksLeft::remove);
        discounts.add(Discount.fromSizeOfSeries(series.size()));

        return hasDiscountLeft(booksLeft) ? accumulateDiscounts(discounts, booksLeft) : discounts;
    }

    private boolean hasDiscountLeft(final List<BookNumber> booksLeft) {
        return Discount.fromSizeOfSeries(new HashSet<>(booksLeft).size()) != null;
    }

}
