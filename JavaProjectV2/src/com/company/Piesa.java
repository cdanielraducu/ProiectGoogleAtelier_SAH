package com.company;

public class Piesa implements Observer {

    char val;

    public Piesa(char val) {
        this.val = val;
    }

    @Override
    public char getValue() {
        return val;
    }
}
