package com.arolla.katapotter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by dpanza on 03/02/2016.
 */
public class DiscountOptimization {

   private static DiscountOptimization instance = new DiscountOptimization();
   private final Predicate<List<Discount>> predicate = (discounts) -> {
      long nbOfTwentyFiveDiscount = discounts.stream().filter(d -> d == Discount.TWENTY_FIVE_DISCOUNT).count();
      long nbOfTenDiscount = discounts.stream().filter(d -> d == Discount.TEN_DISCOUNT).count();
      return nbOfTenDiscount > 0 && nbOfTwentyFiveDiscount > 0;
   };
   private final Function<List<Discount>, List<Discount>> action =  (discounts) -> {
      discounts.remove(Discount.TWENTY_FIVE_DISCOUNT);
      discounts.remove(Discount.TEN_DISCOUNT);
      discounts.add(Discount.TWENTY_DISCOUNT);
      discounts.add(Discount.TWENTY_DISCOUNT);
      return discounts;
   };


   public static DiscountOptimization get(){
      return instance;
   }

   private DiscountOptimization() {
   }

   public boolean available(List<Discount> discounts) {
      return this.predicate.test(discounts);
   }

   public List<Discount> apply(List<Discount> discounts) {
      return this.action.apply(new ArrayList<>(discounts));
   }}
