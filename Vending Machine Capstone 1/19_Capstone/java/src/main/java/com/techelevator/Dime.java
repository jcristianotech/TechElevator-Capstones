package com.techelevator;

public class Dime implements Coin {

    @Override
    public String getName() {
        return "Dime";
    }

    public double getValue(){
        return .10;
    }
}