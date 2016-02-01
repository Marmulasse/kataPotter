package com.arolla.katapotter;

/**
* Created by dpanza on 01/02/16.
*/
public enum BookNumber {
    FIRST(0), SECOND(1), THIRD(2), FOURTH(3), FIFTH(4);

    private final int number;

    BookNumber(int number) {
        this.number = number;
    }


    public static BookNumber valueFromNumber(int number){
        for (BookNumber bookNumber : values()) {
            if(bookNumber.number == number){
                return bookNumber;
            }
        }
        return null;
    }


}
