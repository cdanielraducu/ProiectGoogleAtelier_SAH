package com.company;

public class Player implements Observer2{
    int id;
    boolean castigat;

    public Player(int id) {
        this.id = id;
        castigat = false;
    }

    public boolean isCastigat() {
        return castigat;
    }

    public void setCastigat(boolean castigat) {
        this.castigat = castigat;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void update(String msg) {
        if(isCastigat())
            System.out.println(id + " " + msg);
        else
            System.out.println(id + " " + "nu " + msg);
    }
}
